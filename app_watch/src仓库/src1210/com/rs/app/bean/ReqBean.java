package com.rs.app.bean;

import java.sql.Date;
import java.util.List;

public class ReqBean {
	private int result;
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
	private  double  height;
	private  double weight;
	private  String homeAddress;
	private  String schoolAddress;
	private  String deviceid;
	
	
	
	private  int  anti_stranger_status;
	
	private  int school_guard_enable;
	private  String arrive_school_time_am;
	private  String leave_school_time_am;
	private  String arrive_school_time_pm;
	private  String leave_school_time_pm;
	private  String arrive_home_time;
	
	private  String  school_address_descripe;
	private  Double  latitude;
	private  Double  longitude;
	private int loctype;
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
	
	private Watch_setting watch_setting;
	private Watch_manage watch_manage;
	
	private String message;
	private  int time;//系统时间
	
	private int starttime;//开始时间
	private int endtime;
	
	public void setResult(int result) {
		this.result = result;
	}
	public int getResult() {
		return this.result;
	}
	
	
	public void setPhone_number(String phone_number) {
		this.phone_number =phone_number;
	}
	public String getPhone_number() {
		return this.phone_number;
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
	
	public void setToken(String token) {
		this.token = token;
	}
	public String getToken() {
		return this.token;
	}
	
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getUserid() {
		return this.userid;
	}
	
	public void setNewpassword(String newpassword) {
		this.newpassword =newpassword;
	}
	public String getNewpassword() {
		return this.newpassword;
	}
	public void setProfile_photo(String profile_photo) {
		this.profile_photo = profile_photo;
	}
	public String getProfile_photo() {
		return this.profile_photo;
	}
	
	
	
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getNick_name() {
		return this.nick_name;
	}
	
	
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getSex() {
		return this.sex;
	}
	
	
	public void setDate_birthday(Date date_birthday) {
		this.date_birthday = date_birthday;
	}
	public Date getDate_birthday() {
		return this.date_birthday;
	}
	
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	public String getDeviceid() {
		return this.deviceid;
	}
	
	public void setDeviceIMEI(String deviceIMEI) {
		this.deviceIMEI = deviceIMEI;
	}
	public String getDeviceIMEI() {
		return this.deviceIMEI;
	}
	
	public void setPhoneIMSI(String phoneIMSI) {
		this.phoneIMSI = phoneIMSI;
	}
	public String getPhoneIMSI() {
		return this.phoneIMSI;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	public String getVersion() {
		return this.version;
	}
	
	public void setDevicetype(int devicetype) {
		this.devicetype = devicetype;
	}
	public int getDevicetype() {
		return this.devicetype;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getGrade() {
		return this.grade;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	public double getHeight() {
		return this.height;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getWeight() {
		return this.weight;
	}
	
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getHomeAddress() {
		return this.homeAddress;
	}
	
	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}
	public String getSchoolAddress() {
		return this.schoolAddress;
	}
	
	public void setWatch_setting(Watch_setting watch_setting) {
		this.watch_setting = watch_setting;
	}
	public Watch_setting getWatch_setting() {
		return this.watch_setting;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return this.message;
	}
	

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLatitude() {
		return this.latitude;
	}
	

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLongitude() {
		return this.longitude;
	}
	
	
	public void setLoctype(int loctype) {
		this.loctype = loctype;
	}
	public int getLoctype() {
		return this.loctype;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	public int getTime() {
		return this.time;
	}

	
	public void setStarttime(int starttime) {
		this.starttime = starttime;
	}
	public int getStarttime() {
		return this.starttime;
	}
	
	public void setEndtime(int endtime) {
		this.endtime = endtime;
	}
	public int getEndtime() {
		return this.endtime;
	}
	
	public void setWatch_manage(Watch_manage watch_manage) {
		this.watch_manage = watch_manage;
	}
	public Watch_manage getWatch_manage() {
		return this.watch_manage;
	}
	
	public void setAnti_stranger_status(int anti_stranger_status) {
		this.anti_stranger_status = anti_stranger_status;
	}
	public int getAnti_stranger_status() {
		return this.anti_stranger_status;
	}
}
