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
import com.rs.util.Phone_userid;
import com.rs.util.ReqReader;


public class GetVerifycode extends HttpServlet {
	 
//	  private UserDaoImpl userDaoImpl;
		
		
	  @Override
	public void init() throws ServletException{
	      // 执行必需的初始化
//		  userDaoImpl=new UserDaoImpl();
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
			req.setCharacterEncoding("UTF-8");
			Gson gson = new Gson();
			String json=ReqReader.toStr(req);
			ReqBean reqBean=gson.fromJson(json,ReqBean.class);
			String phone = reqBean.getPhone_number();
			
			//调用第三方接口发送验证码至手机 、将验证码存储
			int userid = Phone_userid.to(phone);
			int send = SendVerifyCode.action(userid);
			
			
//			String code = UserDaoImpl.verifycode_find(reqBean.getMobile());
			
			ResBean res=new ResBean();
			res.setResult(send);
			resp.setCharacterEncoding("UTF-8");
			Map<String,Integer> map = new HashMap();
			map.put("result",res.getResult());
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