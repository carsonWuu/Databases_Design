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
	public static List send(int phone) {
		List<Object> list  =new ArrayList();
		list.add(0);//发送成功为0，失败为-1
		list.add("code1001");//验证码
		return list;
	}
	public static void store(int phone,String vcode){
		try {
			int time = TimeUtil.toSecond();
			UserDaoImpl.verifycode_store(phone,vcode,time);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	public static int action(int phone) {
		List list = send(phone);
		int tag = (int)list.get(0);
		store(phone,(String)list.get(1));
		return tag;
	}
}
