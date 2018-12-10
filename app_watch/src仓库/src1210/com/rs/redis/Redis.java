package com.rs.redis;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.ibatis.common.resources.Resources;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

/**
 * redis数据查询类
 */
public class Redis{
	private Jedis jedis;
//	private Pipeline pipeline;
//    private static redis instance = null;
	public Redis(){
		
		Properties props=null;
		try {
			props = Resources.getResourceAsProperties("redis.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ip = props.getProperty("redis.ip");
		int port = Integer.parseInt(props.getProperty("redis.port"));
		String password = props.getProperty("redis.password");
//		System.out.println(ip+port+password);
		jedis=new Jedis(ip,port);
		jedis.auth(password);
		jedis.select(1);
//		pipeline = jedis.pipelined();
		
	}
	
//	public static redis getInstance(){
//		if(instance == null){
//			instance = new redis();
//		}
//		return instance;
//	}
	
	/** 存userid 与 token 
	 * 
	 * @param nid
	 * @param map
	 */
	public  void Store(String nid,Map<String,String> map){
		
		this.jedis.hmset(nid, map);
		
	}
	
	/**取用户id与token集合
	 * 
	 * @param nid
	 * @return Map<String,String>
	 */
	public boolean Get(int nid,String token) {
		String id = String.valueOf(nid);
		Map<String,String> map= this.jedis.hgetAll(id);
//		System.out.println(map);
		if(null== map) return false;
		String Nid = map.get("userid");
		String Token = map.get("token");
		
//		System.out.println(Token+"\t"+token);
		if(null!=Token && null != Nid && Token.equals(token) && Nid.equals(id)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Redis redis = new Redis();
		redis.Get(17, "token");
	}
	

}