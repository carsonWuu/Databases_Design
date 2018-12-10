package com.rs.app.login;

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
import com.rs.util.TimeUtil;
import com.tonetime.commons.codec.MD5;

/**用户登录
 * @url 1003
 * @author wcs
 *
 */
public class Login extends HttpServlet{
	
	private Gson gson ;	
	private Redis redis;
	@Override
	public void init() throws ServletException{
	     this.gson = new Gson();
	     redis = new Redis();
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
		  	System.out.println("1003接口");
		  	ReqBean  reqBean = ReqAndRes.toReqBean(req, gson);
		  
			ReqBean res=new ReqBean();
			
			int  nid = UserDaoImpl.app_login(reqBean.getPhone_number(),reqBean.getPassword());
			Map<String,String> map = new HashMap();

			if(nid >= 0) {//验证码正确，注册信息录入
				res.setResult(0);
				int time = TimeUtil.toSecond();
				String token= MD5.encode((String)(reqBean.getPhone_number()+time));
				
				res.setUserid(nid);
				
				res.setToken(token);
				map.put("userid",String.valueOf(res.getUserid()));
				map.put("token",res.getToken());
				
				this.redis.Store(String.valueOf(nid), map);
				map.put("diviceList", UserDaoImpl.bind_app_find(res).getMessage());
			}
			else {
				res.setResult(-1);
			}
			map.put("result",String.valueOf(res.getResult()));
			
			ReqAndRes.outPrintL(resp, map, gson);
			
		}
	  
	  @Override
	public void destroy() {
	      // 什么也不做
	  }
	}