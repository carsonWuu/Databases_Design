package com.rs.app.bean;

import java.sql.Date;
import java.util.List;

public class ReqBean {
	private String mobile;
	private String password;
	private String code;
	private int userid;
	private String newpassword;
	private String token;
	private String phone_number;
	private String profile_photo;
	private String nick_name;
	private int sex;
	private Date date_birthday;
	
	private String deviceSTR ;
	private  String deviceIMEI;
	private  String phoneIMSI;
	private int devicetype ;
	private  String  version;
	private  String grade;
	private  String  height;
	private  String weight;
	private  String home_address;
	private  String school_address;
	private  int deviceid;
	private  int screen_light_time;
	private  int ring_call;
	private  int vibration_call;
	private  int ring_message;
	private  int vibration_message;
	private  int class_time_disable;
	
	private  int  class_time_am_enable;
	private  String  class_time_start_am;
	private  String  class_time_end_am;
	
	private  int  class_time_pm_enable;
	private  String  class_time_start_pm;
	private  String  class_time_end_pm;
	
	private  int  class_time_night_enable;
	private  String  class_time_start_night;
	private  String  class_time_end_night;
	
	private List<String> repeat;
	
	private  int  anti_stranger_status;
	
	private  int school_guard_enable;
	private  String arrive_school_time_am;
	private  String leave_school_time_am;
	private  String arrive_school_time_pm;
	private  String leave_school_time_pm;
	private  String arrive_home_time;
	
	private  String  school_address_descripe;
	private  String  latitude;
	private  String  longitude;
	private  int radius;

	private  String  home_address_descripe;
	
	private  int autopower_status;
	private  String powertime;
	private  String offtime;
	
	private  int auto_connect;
	private List address_list;
	
	private  int plan_id;
	private  String plan_name;
	private  String plan_time;
	private  int plan_type;
	private  int plan_status;
	
	private  int holdpower_status;
	private  int call_address_status;
	private  int anti_water_status;
	
	private  String suggestcontent;
	private  String suggestdate;
	
	public void setMobile(String mobile) {
		this.mobile =mobile;
	}
	public String getMobile() {
		return this.mobile;
	}
	
	public void setPassword(String password) {
		this.password =password;
	}
	public String getPassword() {
		return this.password;
	}
	
	public void setCode(String code) {
		this.code =code;
	}
	public String getCode() {
		return this.code;
	}
	
}
