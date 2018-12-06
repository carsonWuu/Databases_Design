package com.rs.util;

public class Phone_userid {
	public static int to(String phone) {
		return Integer.parseInt(phone.substring(3));
	}
}
