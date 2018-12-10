package com.rs.app.register;
import java.util.*;

import com.rs.mysql.UserDaoImpl;
import com.rs.util.TimeUtil;

/**发送验证码到手机 、将验证码存储
 * 
 * @author wcs
 *
 */
public class SendVerifyCode {
	
	@SuppressWarnings("finally")
	public static int store(String phone,String vcode){
		int ret= 0;
		try {
			int time = TimeUtil.toSecond();
			UserDaoImpl.verifycode_store(phone,vcode,time);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ret=-1;
			e.printStackTrace();
		}
		finally {
			return ret;
		}
	};
	public static int action(String phone,String code) {
		return store(phone,code);
		
	}
}
