package com.example.administrator.apptest.callback;

import android.util.Log;


import com.example.administrator.apptest.util.AppException;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;


public abstract class AbstractCallBack<T> implements ICallBack<T>{
	public String path;
	public Class<T> mReturnClass;
	public Type mReturnType;
	private volatile boolean isCancelled;

	@Override
	public T handle(HttpURLConnection connection) throws AppException {
		return handle(connection, null);
	}

	public T handle(HttpURLConnection connection, OnProgressUpdatedListener listener) throws AppException {
		try{
			InputStream is = null;
			int status = connection.getResponseCode();
			if (status == 200) {
				Log.e("response", "OK");
//                support gzip || deflate
				String encoding = connection.getContentEncoding();
				if (encoding != null && "gzip".equalsIgnoreCase(encoding)) {
					is = new GZIPInputStream(connection.getInputStream());
				} else if (encoding != null && "deflate".equalsIgnoreCase(encoding)) {
					is = new InflaterInputStream(connection.getInputStream());
				} else {
					is = connection.getInputStream();
				}
				if (path == null) {
					ByteArrayOutputStream out = new ByteArrayOutputStream();
					byte[] buffer = new byte[2048];
					int len;
					while ((len = is.read(buffer)) != -1) {
						checkIfCancelled();
						out.write(buffer, 0, len);
					}
					is.close();
					out.flush();
					out.close();
					String result = new String(out.toByteArray());
					Log.e("服务器返回的结果0",result);
					T t = bindData(result);
					return postRequest(t);
				} else {
					FileOutputStream out = new FileOutputStream(path);
					int totalLen = connection.getContentLength();
					int curLen = 0;
					byte[] buffer = new byte[2048];
					int len;
					int percent = 0;
					while ((len = is.read(buffer)) != -1) {
						checkIfCancelled();
						out.write(buffer, 0, len);
						if (curLen * 100l / totalLen > percent) {
							curLen += len;
							if (listener != null) {
								listener.onProgressUpdated(curLen, totalLen);
							}
							percent = (int) (curLen * 100l / totalLen);
						}
					}
					is.close();
					out.flush();
					out.close();
					Log.e("服务器返回的结果0",path);

					T t = bindData(path);
					return postRequest(t);
				}
			}else{
				Log.e("response", "~~"+status);
				throw new AppException(AppException.EnumException.StatusCodeException, connection.getResponseMessage());
			}
		} catch (IOException e) {
			throw new AppException(AppException.EnumException.IOException, e.getMessage());
		}
	}

	protected void checkIfCancelled() throws AppException {
		if (isCancelled) {
			throw new AppException(AppException.EnumException.RequestCancel, "the request has been cancelled");
		}
	}

	@Override
	public void cancel() {
		isCancelled = true;
	}

	@Override
	public void onProgressUpdated(int state, int curLen, int totalLen) {

	}
	protected abstract T bindData(String result) throws AppException;
	
	public AbstractCallBack<T> setReturnClass(Class<T> clz){
		this.mReturnClass = clz;
		return this;
	}
	
	public AbstractCallBack<T> setReturnType(Type type){
		this.mReturnType = type;
		return this;
	}

	@Override
	public T postRequest(T t) {
		return t;
	}

	@Override
	public T preRequest() {
		return null;
	}
}
