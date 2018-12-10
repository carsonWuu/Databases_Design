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
import com.rs.app.bean.ReqBean;
import com.rs.app.bean.ResBean;
import com.rs.mysql.UserDaoImpl;

import com.rs.util.ReqAndRes;

public class Register extends HttpServlet{
	 
//	  private UserDaoImpl userDaoImpl;
	Gson gson ;	
		
	  @Override
	public void init() throws ServletException{
	     this.gson = new Gson();
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
			System.out.println("1002接口");
			req.setCharacterEncoding("UTF-8");
			
			ReqBean reqBean=ReqAndRes.toReqBean(req, gson);
			String password = reqBean.getPassword();
			String code = reqBean.getCode();
			
			//校验验证码
			
			String Vcode = UserDaoImpl.verifycode_find(reqBean.getPhone_number());

			int tag= (Vcode.equals(code)) ? 0 : -1 ;
			int nid=-1;
			Map<String,Object> map = new HashMap();
			ReqBean res=new ReqBean();
			if(tag==0) {//验证码正确，注册信息录入
				nid = UserDaoImpl.app_add(reqBean.getPhone_number(),password);
				if(nid>=0) {
					res.setUserid(nid);
					map.put("userid",res.getUserid());
				}
				
			}
						
			res.setResult((nid>=0)?0:-1);
	
			
			map.put("result",res.getResult());
			
			ReqAndRes.outPrint(resp, map, gson);
			
		}
	  
	  @Override
	public void destroy() {
	      // 什么也不做
	  }
	}