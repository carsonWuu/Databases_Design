package com.rs.app.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rs.app.bean.ReqBean;
import com.rs.app.bean.ResBean;

import com.rs.util.ReqAndRes;


public class GetVerifycode extends HttpServlet {
	 
//	  private UserDaoImpl userDaoImpl;
		
	private Gson gson ;		
	  @Override
	public void init() throws ServletException{
		  this.gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	  }

	  @Override
	public void doGet(HttpServletRequest request,
	                    HttpServletResponse response)
	            throws ServletException, IOException {
	      doPost(request,response);
	  }
	  
	  @Override
	public void doPost(HttpServletRequest request,
              HttpServletResponse response)
      throws ServletException, IOException {
		  try {
			process(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  private void process(HttpServletRequest req, HttpServletResponse resp) throws Exception{
			System.out.println("1001接口");
			
			
			ReqBean reqBean=ReqAndRes.toReqBean(req, gson);
			String phone = reqBean.getPhone_number();
			System.out.println(phone);
			
			int send = SendVerifyCode.action(reqBean.getPhone_number(),reqBean.getCode());
			
			
//			String code = UserDaoImpl.verifycode_find(reqBean.getMobile());
			
			ReqBean res=new ReqBean();
			res.setResult(send);
			
			Map<String,Object> map = new HashMap();
			map.put("result",res.getResult());
			
			
			ReqAndRes.outPrint(resp, map, gson);
			
			
			
			
			
		}
	  
	  @Override
	public void destroy() {
	      // 什么也不做
	  }
	}