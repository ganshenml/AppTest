package com.example.administrator.apptest.callback;

import com.example.administrator.apptest.util.AppException;

import java.net.HttpURLConnection;


public interface ICallBack<T> {
	void onFailure(AppException result);
	void onSuccess(T result);
	T preRequest();
	T postRequest(T t);
	T handle(HttpURLConnection connection, OnProgressUpdatedListener listener) throws AppException;
	T handle(HttpURLConnection connection) throws AppException;
	void onProgressUpdated(int state, int curLen, int totalLen);
	void cancel();
}
