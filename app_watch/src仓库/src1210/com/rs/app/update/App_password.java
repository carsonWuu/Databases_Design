package com.rs.app.update;

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
import com.rs.redis.Redis;
import com.rs.util.Req2Bean;
import com.rs.util.ReqAndRes;

/**App密码修改
 * @url 1004
 * @author wcs
 *
 */
public class App_password extends HttpServlet{
	
	private Gson gson ;	
	private Redis redis;
	@Override
	public void init() throws ServletException{
	     this.gson = new Gson();
	     this.redis = new Redis();
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
		  	ReqBean  reqBean = ReqAndRes.toReqBean(req, gson);
		  	
			
			String token = reqBean.getToken();
			Map<String,Object> map = new HashMap();
			ResBean res=new ResBean();
			Boolean LOGIN = this.redis.Get(reqBean.getUserid(),reqBean.getToken());
			System.out.println(LOGIN);
			res.setResult(-1);
			res.setUserid(reqBean.getUserid());
			if(LOGIN) {
				int  line = UserDaoImpl.app_password(reqBean.getUserid(),reqBean.getPassword(),reqBean.getNewpassword());
				

				if(line != 0) {//更新成功
					res.setResult(0);
					
					
				}
				else {
					res.setResult(-1);
				}
				
				
			}
			
				
			map.put("userid",res.getUserid());
			map.put("result",res.getResult());
	
			ReqAndRes.outPrint(resp, map, gson);
			
		}
	  
	  @Override
	public void destroy() {
	      // 什么也不做
	  }
	}