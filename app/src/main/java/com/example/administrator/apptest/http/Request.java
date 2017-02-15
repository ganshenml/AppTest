package com.example.administrator.apptest.http;

import android.os.Build;
import android.util.Log;

import com.example.administrator.apptest.callback.ICallBack;
import com.example.administrator.apptest.callback.OnGlobalExceptionListener;
import com.example.administrator.apptest.entity.FileEntity;
import com.example.administrator.apptest.util.AppException;
import com.example.administrator.apptest.util.Config;
import com.example.administrator.apptest.util.HttpRequestTask;
import com.example.administrator.apptest.util.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

/**
 * HTTP请求实体类
 * @author Administrator
 *
 */
public class Request {



	public enum RequestMethod {
		GET, POST, DELETE, PUT
	}
	
	public Map<String, String> headers = new HashMap<String, String>();
	public RequestMethod method;
	public String url;
	public ICallBack iCallBack;
	public HttpRequestTask requestTask;
	private String urlMethod;
	public volatile boolean isCancelled;
	public String content;
	public String filePath;
	public ArrayList<FileEntity> fileEntities;
	public boolean enableProgressUpdated = false;
	public OnGlobalExceptionListener onGlobalExceptionListener;
	public static final int STATE_UPLOAD = 1;
	public static final int STATE_DOWNLOAD = 2;
	public String tag;
	public boolean isCompleted;
	/**
	 * 请求需要的方法名，请求方式，请求参数
	 * @param urlMethod
	 * @param method
	 * @param requestMap
	 */
	public Request(String urlMethod, RequestMethod method, HashMap<String, Object> requestMap){
		this.urlMethod = urlMethod;
		if(method == method.GET){
			this.url = Config.api_url + urlMethod + setGetUrl(requestMap);
		}else if(method == method.POST){
			this.url = Config.api_url + urlMethod;
			setPostJSONContent(requestMap);
		}
		this.method = method;

	}

	public Request(boolean isLongUrl, String urlMethod, RequestMethod method, HashMap<String, Object> requestMap){
		this.urlMethod = urlMethod;
		if(method == method.GET){
			this.url = urlMethod + setGetUrl(requestMap);
		}else if(method == method.POST){
			this.url = urlMethod;
			setPostJSONContent(requestMap);
		}
		this.method = method;
	}

	public String setGetUrl(HashMap<String, Object> requestMap){
		StringBuilder sb = new StringBuilder();
		Iterator iter = requestMap.entrySet().iterator();
		while (iter.hasNext()){
			Map.Entry<String, Object> entry = (Map.Entry<String, Object>)iter.next();
			if(sb.length() == 0){
				sb.append("?");
			}else{
				sb.append("&");
			}
			sb.append(entry.getKey()+"="+entry.getValue());
		}
//		L.e(urlMethod + "~~~~Get~~~~" + sb.toString());
		return sb.toString();
	}
	
	public void setPostContent(HashMap<String, Object> requestMap){
		StringBuilder sb = new StringBuilder();
		Iterator iter = requestMap.entrySet().iterator();
		while (iter.hasNext()){
			Map.Entry<String, Object> entry = (Map.Entry<String, Object>)iter.next();
			if(sb.length() != 0){
				sb.append("&");
			}
			sb.append(entry.getKey()+"="+entry.getValue());
		}
//		L.e(urlMethod + "~~~~Post~~~~" + sb.toString());
		content = sb.toString();
	}

	public void setPostJSONContent(HashMap<String, Object> requestMap){
		String json = JsonParser.toJson(requestMap);
//		L.e(urlMethod + "~~~~Post~~~~" + json);
		headers.put("Content-type", "application/json; charset=utf-8");
		content = json;
	}

	public void setCallBack(ICallBack iCallBack){
		this.iCallBack = iCallBack;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void execute(Executor mExecutors) {
		requestTask = new HttpRequestTask(this);
		if (Build.VERSION.SDK_INT > 11){
			requestTask.executeOnExecutor(mExecutors);
		}else {
			requestTask.execute();
		}
	}
	public void checkIfCancelled() throws AppException {
		if (isCancelled){
			throw new AppException(AppException.EnumException.RequestCancel,"the request has been cancelled");
		}
	}
	public void enableProgressUpdated(boolean enable) {
		this.enableProgressUpdated = enable;
	}
	public void setGlobalExceptionListener(OnGlobalExceptionListener onGlobalExceptionListener) {
		this.onGlobalExceptionListener = onGlobalExceptionListener;
	}

	public void cancel(boolean force) {
		isCancelled = true;
		iCallBack.cancel();
		if (force && requestTask != null){
			requestTask.cancel(force);
		}
	}
}
