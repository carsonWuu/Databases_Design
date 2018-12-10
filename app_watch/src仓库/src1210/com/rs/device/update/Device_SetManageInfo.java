package com.rs.device.update;

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
import com.rs.mysql.UserDaoImpl;
import com.rs.util.Req2Bean;

/**更新上课禁用、重复
 * 
 * @author wcs
 *
 */
public class Device_SetManageInfo extends HttpServlet{
	
	Gson gson ;	
	
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
		  	ReqBean  reqBean = Req2Bean.toBean(gson, req, resp);
		  	resp.setCharacterEncoding("UTF-8");
		  	int userid = reqBean.getUserid();
			
			String token = reqBean.getToken();
			
			
			int line  = UserDaoImpl.device_setmanageinfo(reqBean);
			
			Map<String,Object> map = new HashMap();
			/*
			 * 
{
 "userid": "10",
 "deviceid": "14",
 "watch_manage": {
  "class_time_disable": "1",
  "class_time_am_enable": "1",
  "class_time_start_am": "0800",
  "class_time_end_am": "1130",
  "class_time_pm_enable": "1",
  "class_time_start_pm": "1400",
  "class_time_end_pm": "1700",
  "class_time_night_enable": "1",
  "class_time_start_night": "2100",
  "class_time_end_night": "2400",
  "repeat": [1, 2, 3]
 },
 "token": "7a57a5a743894a0e"
}
			 */
			ReqBean res = new ReqBean();
			
			if(line != 0) {//查找有内容
				res.setResult(0);
				map.put("userid",userid);
				
			}
			else {
				res.setResult(-1);
			}
				
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
