package com.rs.device.info;

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
import com.rs.mysql.UserDaoImpl;
import com.rs.util.Req2Bean;

public class Device_GetInfo extends HttpServlet{
	
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
			
			
			ReqBean  res = UserDaoImpl.device_info(reqBean.getDeviceid());
			Map<String,Object> map = new HashMap();

			/*
			 * "result":”0”,
"phone_number":"13800000000",
"deviceIMEI":"123456789012345",
"phoneIMSI":"1234567890123456",
"devicetype":"1",
"version":"Watch1.0",
"Profilephoto":"",
"Nickname":"哥哥"，
"Sex":"1";
"date_birthday":"2012-03-02",
"grade":"小学一年级",
"height":"130",
"weight":"25",
"homeAddress":"广东省深圳市",
"schoolAddress":"广东省深圳市"
			 */
			if(null != res) {//查找有内容
				res.setResult(0);
				map.put("userid",userid);
				map.put("phone_number", res.getPhone_number());
				map.put("profilephoto", res.getProfile_photo());
				map.put("nickname", res.getNick_name());
				map.put("sex", res.getSex());
				map.put("date_birthday", res.getDate_birthday());
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
