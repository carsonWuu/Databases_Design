package com.rs.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {
	private static MessageDigest digester;

    static {
        try {
            digester = MessageDigest.getInstance("MD5");
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将任意的字符串进行md5加密，并返回加密后的十六进制字符串。
     * 需要注意，MessageDigest是非线程安全的，所以需要使用synchronized同步。
     * @param str 待加密字符串
     * @return 返回md5加密后的十六进制字符串
     */
    public static String encrypt(String str) {
        if (digester == null || str == null || str.length() == 0) {
            return null;
        }
        
        synchronized (digester){
            try {
                digester.update(str.getBytes("UTF-8"));
                String s1 = new BigInteger(1, digester.digest()).toString(16);
                //补齐BigInteger省略的前置0
                return new String(new char[32 - s1.length()]).replace("\0", "0") + s1;
            } catch (Exception e) {
                //一般不会有异常抛出， 该死的Java受检异常，导致丑陋的代码
            }
        }

        return null;
    }

}
