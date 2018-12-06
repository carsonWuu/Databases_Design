package com.rs.mysql;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

import com.rs.app.bean.ReqBean;
import com.rs.app.bean.ResBean;
import com.tonetime.commons.database.helper.DbHelper;
import com.tonetime.commons.database.helper.JdbcCallback;


/**
 * 从数据库查询数据
 */
public class UserDaoImpl{
	
	/**
	 * 登陆验证
	 */
	
	
	public  static void verifycode_store(final int phone,final String code,final int time) throws Exception{
		
		DbHelper.execute(DataSourceBuilder.getInstance().getDataSource(), new JdbcCallback() {
			
					@Override
					public Object doInJdbc(Connection arg0) throws SQLException, Exception {
						
						final String sqlCom="{call Verification_add(?,?,?)}";
						CallableStatement cs = arg0.prepareCall(sqlCom);
						cs.setObject(1, phone);
			            cs.setObject(2, code);
			            cs.setObject(3,time);
			            cs.execute();
						return sqlCom;
					}
				});
				
	}
	
	public  static String  verifycode_find(final int id) throws Exception{
		
		String ret=(String) DbHelper.execute(DataSourceBuilder.getInstance().getDataSource(), new JdbcCallback() {
			
					@Override
					public Object doInJdbc(Connection arg0) throws SQLException, Exception {
						
						final String sqlCom="{call Verification_find(?,?)}";
						CallableStatement cs = arg0.prepareCall(sqlCom);
						String code=null;
						cs.setObject(1,id);
						cs.registerOutParameter(2, Types.VARCHAR); // 设置返回值类型 即返回值 
				        cs.execute(); // 执行存储过程 
				        code = cs.getString(2); 
			            
						return code;
					}
				});
		return ret;		
	}
	
	public  static void  app_add(final int id,final String phone ,final String password ) throws Exception{
		
		DbHelper.execute(DataSourceBuilder.getInstance().getDataSource(), new JdbcCallback() {
			
					@Override
					public Object doInJdbc(Connection arg0) throws SQLException, Exception {
						
						final String sqlCom="{call App_add(?,?,?)}";
						CallableStatement cs = arg0.prepareCall(sqlCom);
						String code=null;
						cs.setObject(1,id);
						cs.setObject(2,phone);
						cs.setObject(3,password);
						
				        cs.execute(); // 执行存储过程 
				        cs.close();
			            
						return "";
					}
			});
				
	}
	
	public  static String  app_login(final String phone ,final String password ) throws Exception{
		
		Object ret = DbHelper.execute(DataSourceBuilder.getInstance().getDataSource(), new JdbcCallback() {
			
					@Override
					public Object doInJdbc(Connection arg0) throws SQLException, Exception {
						
						final String sqlCom="{call App_login(?,?,?)}";
						CallableStatement cs = arg0.prepareCall(sqlCom);
						String code=null;
						cs.setObject(1,phone);
						
						cs.setObject(2,password);
						
						cs.registerOutParameter(3, Types.VARCHAR); // 设置返回值类型 即返回值 
						
				        cs.execute(); // 执行存储过程 
				        //不空，则正确
				        String temp = null;
				        
				        temp = cs.getString(3);
				        		
				        cs.close();
			            
						return temp;
					}
			});
		return (String)ret;
				
	}
	
public  static int  app_password(final int userid , final String password ,final String newpassword ) throws Exception{
		
		Object ret = DbHelper.execute(DataSourceBuilder.getInstance().getDataSource(), new JdbcCallback() {
			
					@Override
					public Object doInJdbc(Connection arg0) throws SQLException, Exception {
						
						final String sqlCom="{call App_update_password(?,?,?)}";
						CallableStatement cs = arg0.prepareCall(sqlCom);
						String code=null;
						cs.setObject(1,userid);
						
						cs.setObject(2,password);
						
						cs.setObject(3,newpassword);
						
						
				        int n = cs.executeUpdate(); // 执行存储过程 
				        
				        
				        
				        
				        		
				        cs.close();
			            
						return n;
					}
			});
		return (int)ret;
				
	}


	public  static ResBean  app_info(final int userid) throws Exception{
	
		Object ret = DbHelper.execute(DataSourceBuilder.getInstance().getDataSource(), new JdbcCallback() {
		
				@Override
				public Object doInJdbc(Connection arg0) throws SQLException, Exception {
					
					final String sqlCom="{call App_info(?,?,?,?,?,?)}";
					CallableStatement cs = arg0.prepareCall(sqlCom);
					String code=null;
					cs.setObject(1,userid);
					
					cs.registerOutParameter(2, Types.VARCHAR); // phone 
					cs.registerOutParameter(3, Types.VARCHAR); // profilephoto
					cs.registerOutParameter(4, Types.VARCHAR); // nickname
					cs.registerOutParameter(5, Types.TINYINT); // sex
					cs.registerOutParameter(6, Types.DATE); // birthday
					
					
					int n = cs.executeUpdate(); // 执行存储过程 
					
					ResBean resBean =new ResBean();
					
					resBean.setPhone_number(cs.getString(2));
					resBean.setProfile_photo(cs.getString(3));
					resBean.setNick_name(cs.getString(4));
					resBean.setSex(cs.getInt(5));
					resBean.setDate_birthday(cs.getDate(6));
					
			        
			        
			        		
			        cs.close();
		            
					return resBean;
				}
		});
	return (ResBean)ret;
			
	}
	
	public  static int  app_setinfo(final int userid , final String phone_number ,final String profile_photo ,final String nick_name ,final int sex,final Date date_birthday) throws Exception{
		
		Object ret = DbHelper.execute(DataSourceBuilder.getInstance().getDataSource(), new JdbcCallback() {
			
					@Override
					public Object doInJdbc(Connection arg0) throws SQLException, Exception {
						
						final String sqlCom="{call App_update_info(?,?,?,?,?,?)}";
						CallableStatement cs = arg0.prepareCall(sqlCom);
						String code=null;
						cs.setObject(1,userid);
						
						cs.setObject(2,phone_number);
						
						cs.setObject(3,profile_photo);
						
						cs.setObject(4,nick_name);
						cs.setObject(5,sex);
						cs.setObject(6,date_birthday);
						
				        int n = cs.executeUpdate(); // 执行存储过程 
				        
				        
				        
				        
				        		
				        cs.close();
			            
						return n;
					}
			});
		return (int)ret;
				
	}
	
public  static int  remove_bind(final int userid , final String deviceid) throws Exception{
		
		Object ret = DbHelper.execute(DataSourceBuilder.getInstance().getDataSource(), new JdbcCallback() {
			
					@Override
					public Object doInJdbc(Connection arg0) throws SQLException, Exception {
						
						final String sqlCom="{call Bind_delete(?,?)}";
						CallableStatement cs = arg0.prepareCall(sqlCom);
						
						cs.setObject(1,deviceid);
						
						cs.setObject(2,userid);
						
						
						
				        int n = cs.executeUpdate(); // 执行存储过程 
				        
				        
				        System.out.println(n);
				        
				        		
				        cs.close();
			            
						return n;
					}
			});
		return (int)ret;
				
	}

public  static ReqBean  device_info(final String userid) throws Exception{
	
	Object ret = DbHelper.execute(DataSourceBuilder.getInstance().getDataSource(), new JdbcCallback() {
	
			@Override
			public Object doInJdbc(Connection arg0) throws SQLException, Exception {
				
				final String sqlCom="{call Device_info(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
				CallableStatement cs = arg0.prepareCall(sqlCom);
				String code=null;
				cs.setObject(1,userid);
				
				cs.registerOutParameter(2, Types.VARCHAR); // phone 
				cs.registerOutParameter(3, Types.VARCHAR); // profilephoto
				cs.registerOutParameter(4, Types.VARCHAR); // nickname
				cs.registerOutParameter(5, Types.TINYINT); // sex
				cs.registerOutParameter(6, Types.VARCHAR);
				cs.registerOutParameter(7, Types.VARCHAR);
				cs.registerOutParameter(8, Types.VARCHAR);
				cs.registerOutParameter(9, Types.TINYINT);
				cs.registerOutParameter(10, Types.DATE);
				cs.registerOutParameter(11, Types.VARCHAR);
				cs.registerOutParameter(12, Types.DOUBLE);
				cs.registerOutParameter(13, Types.DOUBLE);
				cs.registerOutParameter(14, Types.VARCHAR);
				cs.registerOutParameter(15, Types.VARCHAR);
				int n = cs.executeUpdate(); // 执行存储过程 
				
				ReqBean resBean =new ReqBean();
				
				resBean.setPhone_number(cs.getString(2));
				resBean.setDeviceIMEI(cs.getString(3));
				resBean.setPhoneIMSI(cs.getString(4));
				
				resBean.setDevicetype(cs.getInt(5));
				resBean.setVersion(cs.getString(6));
				
				
				resBean.setProfile_photo(cs.getString(7));
				
				resBean.setNick_name(cs.getString(8));
				resBean.setSex(cs.getInt(9));
				resBean.setDate_birthday(cs.getDate(10));
				
				resBean.setGrade(cs.getString(11));
				resBean.setHeight(cs.getDouble(12));
				resBean.setWeight(cs.getDouble(13));
				
				resBean.setHomeAddress(cs.getString(14));
				resBean.setSchoolAddress(cs.getString(15));
		        
		        
		        		
		        cs.close();
	            
				return resBean;
			}
	});
return (ReqBean)ret;
		
}
}
