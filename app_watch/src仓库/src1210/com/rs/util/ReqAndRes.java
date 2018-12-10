package com.rs.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.rs.app.bean.ReqBean;
import com.rs.mysql.UserDaoImpl;

/**输入输出类
 * 
 */
public class ReqAndRes {
	
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
	
	/**输出转换为ReqBean
	 * 
	 * @param gson
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	public static ReqBean toReqBean(HttpServletRequest req,Gson gson) throws IOException, UnsupportedEncodingException{ 
		 
		// 读取请求内容
		return gson.fromJson(toStr(req), ReqBean.class);
		
	}
	/**返回给调用者
	 * 
	 * @param resp
	 * @param map
	 * @param gson
	 * @throws IOException
	 */
	public static void outPrint(HttpServletResponse resp,Map<String,Object> map,Gson gson) throws IOException {
		resp.setCharacterEncoding("UTF-8");
	  	

		String ret = gson.toJson(map);
		ret = ret.replaceAll("\"\\[", "\\[").replaceAll("\\]\"", "\\]").replaceAll("\\\\", "");
		System.out.println(ret);
		
		PrintWriter out = resp.getWriter();
		out.println(ret);
		
		out.close();
	}
	
	public static void outPrintL(HttpServletResponse resp,Map<String,String> map,Gson gson) throws IOException {
		resp.setCharacterEncoding("UTF-8");
	  	

		String ret = gson.toJson(map);
		ret = ret.replaceAll("\"\\[", "\\[").replaceAll("\\]\"", "\\]").replaceAll("\\\\", "");
		System.out.println(ret);
		
		PrintWriter out = resp.getWriter();
		out.println(ret);
		
		out.close();
	}
}
