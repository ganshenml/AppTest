package com.example.administrator.apptest.util;



import android.os.AsyncTask;
import android.util.Log;

import com.example.administrator.apptest.callback.OnProgressUpdatedListener;
import com.example.administrator.apptest.http.Request;

import java.net.HttpURLConnection;

/**
 * HTTP异步请求处理类
 * @author Administrator
 *
 */
public class HttpRequestTask extends AsyncTask<Void, Integer, Object> {
	
	private Request request;

	public HttpRequestTask(Request request){
		this.request = request;
	}

	@Override
	protected Object doInBackground(Void... params) {
		if (request.iCallBack != null) {
			Object object = request.iCallBack.preRequest();
			if (object != null) {
				return object;
			}
		}
		return request(0);
	}

	public Object request(int retry) {
		try {
//          FIXME: if you read the source code of Volley, you will also find this config
//            FIXME: you can also define a param in @Request to config outside
			//if(Build.VERSION.SDK_INT >= 9){
				HttpURLConnection connection = HttpUrlContentionUtil.execute(request, !request.enableProgressUpdated ? null : new OnProgressUpdatedListener() {
					@Override
					public void onProgressUpdated(int curLen, int totalLen) {
						publishProgress(Request.STATE_UPLOAD, curLen, totalLen);
					}
				});
				if (request.enableProgressUpdated) {
					return request.iCallBack.handle(connection, new OnProgressUpdatedListener() {
						@Override
						public void onProgressUpdated(int curLen, int totalLen) {
							publishProgress(Request.STATE_DOWNLOAD,curLen, totalLen);
						}
					});
				} else {
					return request.iCallBack.handle(connection);
				}
//			}else {
//			}
		} catch (AppException e) {
			return e;
		}
	}

	@Override
	protected void onCancelled() {
		super.onCancelled();
	}

	@Override
	protected void onPostExecute(Object result) {
		super.onPostExecute(result);
		Log.e("服务器返回的结果1",JsonParser.toJson(result));

		try {
			request.isCompleted = true;
			if (result instanceof AppException) {
				if (request.onGlobalExceptionListener != null) {
					if (!request.onGlobalExceptionListener.handleException((AppException) result)) {
						request.iCallBack.onFailure((AppException) result);
					}
				} else {
					request.iCallBack.onFailure((AppException) result);
				}
			} else {
				request.iCallBack.onSuccess(result);
			}
		}catch (Exception e){
		}

	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		super.onProgressUpdate(values);
		request.iCallBack.onProgressUpdated(values[0], values[1], values[2]);

	}
}
