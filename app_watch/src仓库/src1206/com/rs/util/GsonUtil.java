package com.rs.util;

import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class GsonUtil {
	public static Gson gson = new Gson();
	
	/**
	 * 
	 * @param <T>
	 * @param json 
	 * @param type  UserBean[].class
	 * @return
	 */
	public static <T> List<T> getListFromJSON(String json, Class<T[]> type) {
		T[] list = GsonUtil.gson.fromJson(json, type);
		return Arrays.asList(list);
	}
}