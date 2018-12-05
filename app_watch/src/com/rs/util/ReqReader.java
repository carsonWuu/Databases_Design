package com.rs.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

public class ReqReader {
	public static String toStr(HttpServletRequest request) throws IOException, UnsupportedEncodingException {
 
		// 读取请求内容
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
	}
}
