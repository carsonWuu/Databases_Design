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
import com.rs.util.Phone_userid;
import com.rs.util.ReqReader;

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
			
			String json=ReqReader.toStr(req);
			ReqBean reqBean=gson.fromJson(json,ReqBean.class);
			String phone = reqBean.getPhone_number();
			String password = reqBean.getPassword();
			String code = reqBean.getCode();
			
			//校验验证码
			
			
			int userid = Phone_userid.to(phone);
			String Vcode = UserDaoImpl.verifycode_find(userid);
			
//			System.out.println("clientcode:"+code);
//			System.out.println("databases:"+Vcode);
			int tag= (Vcode.equals(code)) ? 0 : -1 ;
			if(tag==0) {//验证码正确，注册信息录入
				UserDaoImpl.app_add(userid,phone,password);
			}
			ResBean res=new ResBean();
			
			res.setResult(tag);
			
			
			res.setUserid(userid);
			resp.setCharacterEncoding("UTF-8");
			Map<String,Integer> map = new HashMap();
			map.put("result",res.getResult());
			map.put("userid",res.getUserid());
			String ret = gson.toJson(map);
			System.out.println(ret);
			
			PrintWriter out = resp.getWriter();
			out.println(ret);
			
			out.close();
			
		}
	  
	  @Override
	public void destroy() {
	      // 什么也不做
	  }
	}