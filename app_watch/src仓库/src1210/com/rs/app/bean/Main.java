package com.rs.app.bean;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



public class Main {

	public static void main(String[] args) {
//	    test1();
//	    }
//
//	    /**
//	     * json字符串转基本数据类型(String虽不是基本数据类型，但是是值传递，与基本数据类型处理相似)
//	     */
//	    public static void test1() {
//	    	Gson gson = new Gson();
//	        int i = gson.fromJson("100", int.class); // 100
//	        double d = gson.fromJson("\"99.99\"", double.class); // 99.99
//	        boolean b = gson.fromJson("true", boolean.class); // true
//	        String str = gson.fromJson("String", String.class); // String
//
//	        System.out.println(i);
//	        System.out.println(d);
//	        System.out.println(b);
//	        System.out.println(str);
//	    }

		String json ="{\"userid\":\"10\",\"phone_number\":\"13800000000\",\"profile_photo\":\"\",\"nick_name\":\"test\",\"sex\":\"1\",\"date_birthday\":\"2010-01-07\",\"token\":\"7a57a5a743894a0e\"}";

		
		System.out.println(json);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		ReqBean reqBean=gson.fromJson(json,ReqBean.class);
		System.out.println(reqBean.getDate_birthday()+reqBean.getPhone_number()+reqBean.getPassword());
	}

}
