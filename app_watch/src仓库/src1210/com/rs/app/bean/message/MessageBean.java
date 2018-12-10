package com.rs.app.bean.message;

public class MessageBean {
	private String fromID;
	private String content;
	private int message_type;
	private String voiceurl;
	
	public void setFromID(String fromID) {
		this.fromID = fromID;
	}
	public String getFromID() {
		return this.fromID;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return this.content;
	}
	
	public void setMessage_type(int message_type) {
		this.message_type = message_type;
	}
	public int getMessage_type() {
		return this.message_type;
	}
	
	public void setVoiceurl(String voiceurl) {
		this.voiceurl = voiceurl;
	}
	public String getVoiceurl() {
		return this.voiceurl;
	}
}
