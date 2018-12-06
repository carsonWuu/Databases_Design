package com.rs.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.rs.app.bean.ReqBean;

public class Req2Bean {
	public static ReqBean toBean(Gson gson,HttpServletRequest req, HttpServletResponse resp) throws Exception{
		req.setCharacterEncoding("UTF-8");
		
		String json=ReqReader.toStr(req);
		json = json.replace("'", "\'");
		System.out.println(json);
		ReqBean reqBean=gson.fromJson(json,ReqBean.class);
		return reqBean;
	}
}
