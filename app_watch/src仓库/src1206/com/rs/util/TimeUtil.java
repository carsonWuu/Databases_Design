package com.rs.util;

import java.util.Date;

public class TimeUtil {
	public static int toSecond(){  
		Date date = new Date();
	    if (null == date) {  
	        return 0;  
	    }  
	    String timestamp = String.valueOf(date.getTime());  
	    int length = timestamp.length();  
	    if (length > 3) {  
	        return Integer.valueOf(timestamp.substring(0,length-3));  
	    } else {  
	        return 0;  
	    }  
	}
	public static void main(String[] args) {
		int time = toSecond();
		System.out.println(time);
	}
}
