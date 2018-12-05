package com.rs.app.register;

import com.rs.mysql.UserDaoImpl;

/**发送验证码到手机 、将验证码存储
 * 
 * @author wcs
 *
 */
public class SendVerifyCode {
	public static String send() {
		return "code1001";
	}
	public static void store(String vcode){
		try {
			UserDaoImpl.verifycode_store("180386835",vcode,153565);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	public static void action() {
		String code = send();
		store(code);
	}
}
