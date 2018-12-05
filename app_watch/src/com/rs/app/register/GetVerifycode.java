package com.rs.app.register;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.google.gson.Gson;
import com.rs.app.bean.ReqBean;
import com.rs.mysql.UserDaoImpl;
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
			System.out.println(reqBean.getCode()+reqBean.getMobile()+reqBean.getPassword());
			SendVerifyCode.action();
			String code = UserDaoImpl.verifycode_find("180386835");
		
			System.out.println(code);
			
			
//			List<Map<String,Object>> list=userDaoImpl.checkLogin("","");
//			
//			if(list.size()==0){//用户名或密码错误！
//				System.out.println("用户名或密码错误！");
//				req.setAttribute("loginError","用户名或密码错误！");
//				req.getRequestDispatcher("login.jsp").forward(req,resp);
//				return;
//			}else{//登录成功！
//				
//			}
			
		}
	  
	  @Override
	public void destroy() {
	      // 什么也不做
	  }
	}