package com.rs.app.bean;

import com.google.gson.Gson;



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

		String json = "{\n" +
                "  \"mobile\": \"18013131\",\n" +
                "  \"password\": \"ok\",\n" +
                
                "    \"code\": \"JSESSIONID=abcntKeuJhop56LGykfdw\"\n" +
               
                "}";
		System.out.println(json);
		Gson gson = new Gson();
		ReqBean reqBean=gson.fromJson(json,ReqBean.class);
		System.out.println(reqBean.getCode()+reqBean.getMobile()+reqBean.getPassword());
	}

}
