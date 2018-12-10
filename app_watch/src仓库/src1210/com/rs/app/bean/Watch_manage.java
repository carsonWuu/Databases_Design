package com.rs.app.bean;

import java.util.List;

public class Watch_manage {

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
	
	private List<Integer> repeat;//重复
	
	public void setClass_time_disable(int class_time_disable) {
		this.class_time_disable = class_time_disable;
	}
	public int getClass_time_disable() {
		return this.class_time_disable;
	}
	//早上
	public void setClass_time_am_enable(int class_time_am_enable) {
		this.class_time_am_enable = class_time_am_enable;
	}
	public int getClass_time_am_enable() {
		return this.class_time_am_enable;
	}
	
	public void setClass_time_start_am(String class_time_start_am) {
		this.class_time_start_am = class_time_start_am;
	}
	
	public String getClass_time_start_am() {
		return this.class_time_start_am;
	}
	
	public void setClass_time_end_am(String class_time_end_am) {
		this.class_time_end_am = class_time_end_am;
	}
	
	public String getClass_time_end_am() {
		return this.class_time_end_am;
	}
	//中午
	public void setClass_time_pm_enable(int class_time_pm_enable) {
		this.class_time_pm_enable = class_time_pm_enable;
	}
	public int getClass_time_pm_enable() {
		return this.class_time_pm_enable;
	}
	
	public void setClass_time_start_pm(String class_time_start_pm) {
		this.class_time_start_pm = class_time_start_pm;
	}
	
	public String getClass_time_start_pm() {
		return this.class_time_start_pm;
	}
	
	public void setClass_time_end_pm(String class_time_end_pm) {
		this.class_time_end_pm = class_time_end_pm;
	}
	
	public String getClass_time_end_pm() {
		return this.class_time_end_am;
	}
	//晚上
	public void setClass_time_night_enable(int class_time_night_enable) {
		this.class_time_night_enable = class_time_night_enable;
	}
	public int getClass_time_night_enable() {
		return this.class_time_night_enable;
	}
	
	public void setClass_time_start_night(String class_time_start_night) {
		this.class_time_start_night = class_time_start_night;
	}
	
	public String getClass_time_start_night() {
		return this.class_time_start_night;
	}
	
	public void setClass_time_end_night(String class_time_end_night) {
		this.class_time_end_night = class_time_end_night;
	}
	
	public String getClass_time_end_night() {
		return this.class_time_end_night;
	}
	
	public void setRepeat(List<Integer> repeat) {
		this.repeat=repeat;
	}
	public List<Integer> getRepeat() {
		return this.repeat;
	}
	
	
	
}
