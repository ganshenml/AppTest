package com.example.administrator.apptest.util;

import com.google.gson.Gson;

import java.lang.reflect.Type;



public class JsonParser {
	public static Gson gson = new Gson();

	public static <T> T deserializeByJson(String data, Type type) {
		if (!StringUtils.isEmpty(data)) {
			return gson.fromJson(data, type);
		}
		return null;
	}
	
	public static <T> T deserializeByJson(String data, Class<T> clz) {
		if (!StringUtils.isEmpty(data)) {
			return gson.fromJson(data, clz);
		}
		return null;
	}

	public static <T> String serializeToJson(T t) {
		if (t == null) {
			return "";
		}
		return gson.toJson(t);
	}

	public static String toJson(Object object){
		return gson.toJson(object);
	}
	
}