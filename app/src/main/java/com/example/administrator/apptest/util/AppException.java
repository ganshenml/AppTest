package com.example.administrator.apptest.util;

public class AppException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EnumException enumException;
	private String exceptionMessage;
	
	public enum EnumException{
		ParseException, IOException, ClientProtocolException, HttpClienUtilException,
		NormalException, CloudException, StatusCodeException, ConnectTimeoutException, SocketTimeoutException, EXCEPTION,
		CallbackSetDataException, RequestCancel, MANUAL, TIMEOUT, SERVER, IO, Upload
	}

	public AppException(EnumException enumException, String exceptionMessage) {
		this.enumException = enumException;
		this.exceptionMessage = exceptionMessage;
	}
	
	public String getExceptionMessage(){
		return exceptionMessage;
	}
	
	public EnumException getEnumException(){
		return enumException;
	}
}
