package com.rs.app.bean.location;

public class LocationBean {
	private  int time;//系统时间
	private  Double  latitude;
	private  Double  longitude;
	private int loctype;
	
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
}
