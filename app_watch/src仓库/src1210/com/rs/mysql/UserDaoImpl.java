package com.rs.mysql;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.rs.app.bean.ReqBean;
import com.rs.app.bean.ResBean;
import com.rs.app.bean.Watch_manage;
import com.rs.app.bean.Watch_setting;
import com.rs.app.bean.location.LocationBean;
import com.rs.app.bean.message.MessageBean;
import com.tonetime.commons.database.helper.DbHelper;
import com.tonetime.commons.database.helper.JdbcCallback;


/**
 * 从数据库查询数据
 */
public class UserDaoImpl{
	
	/**
	 * 登陆验证
	 */
	
	
	public  static void verifycode_store(final String phone,final String code,final int time) throws Exception{
		
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
	
	public  static String  verifycode_find(final String phone) throws Exception{
		
		String ret=(String) DbHelper.execute(DataSourceBuilder.getInstance().getDataSource(), new JdbcCallback() {
			
					@Override
					public Object doInJdbc(Connection arg0) throws SQLException, Exception {
						
						final String sqlCom="{call Verification_find(?,?)}";
						CallableStatement cs = arg0.prepareCall(sqlCom);
						String code=null;
						cs.setObject(1,phone);
						cs.registerOutParameter(2, Types.VARCHAR); // 设置返回值类型 即返回值 
				        cs.execute(); // 执行存储过程 
				        code = cs.getString(2); 
			            
						return code;
					}
				});
		return ret;		
	}
	
	public  static int  app_add(final String phone ,final String password ){
		
		int obj=0;
		try {
			obj = (int)DbHelper.execute(DataSourceBuilder.getInstance().getDataSource(), new JdbcCallback() {
				
						@Override
						public Object doInJdbc(Connection arg0) throws SQLException, Exception {
							
							final String sqlCom="{call App_add(?,?,?)}";
							CallableStatement cs = arg0.prepareCall(sqlCom);
							
							cs.setObject(1,phone);
							cs.setObject(2,password);
							cs.registerOutParameter(3, Types.INTEGER);
							
							
					        cs.execute(); // 执行存储过程 
					        int n =cs.getInt(3);
					        cs.close();
				            
							return n;
						}
				});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			obj=-1;
			e.printStackTrace();
		}
		return obj;
				
	}
	
	public  static int  app_login(final String phone ,final String password ) {
		
		int  ret=0;
		try {
			ret =(int) DbHelper.execute(DataSourceBuilder.getInstance().getDataSource(), new JdbcCallback() {
				
						@Override
						public Object doInJdbc(Connection arg0) throws SQLException, Exception {
							
							final String sqlCom="{call App_login(?,?,?)}";
							CallableStatement cs = arg0.prepareCall(sqlCom);
							
							cs.setObject(1,phone);
							
							cs.setObject(2,password);
							
							cs.registerOutParameter(3, Types.INTEGER);
							
					        cs.execute(); // 执行存储过程 
					        
					        int n = cs.getInt(3);
					        		
					        cs.close();
				            
							return n;
						}
				});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ret = -1;
			e.printStackTrace();
		}
		return ret;
				
	}
	
	/**查找用户的所有绑定设备id
	 * 
	 * @param reqBean
	 * @return
	 * @throws Exception
	 */
	public  static ReqBean  bind_app_find(final ReqBean reqBean) throws Exception{
		
		Object ret = DbHelper.execute(DataSourceBuilder.getInstance().getDataSource(), new JdbcCallback() {
		
				@Override
				public Object doInJdbc(Connection arg0) throws SQLException, Exception {
					
					final String sqlCom="{call Bind_app_find(?)}";
					CallableStatement cs = arg0.prepareCall(sqlCom);
					
					cs.setObject(1,reqBean.getUserid());
								
					ResultSet rs = cs.executeQuery(); // 执行存储过程 
					List<String> list = new LinkedList();
					while(rs.next()) {
							
						list.add(rs.getString(1));
					}
					
					
					Gson gson = new Gson();	        
			        
					rs.close();
			        cs.close();
		            ReqBean resp = new ReqBean();
		            
		            resp.setMessage(gson.toJson(list));
		            System.out.println("list"+resp.getMessage());
					return resp;
				}
			});
		return (ReqBean)ret;
			
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
	
	public  static int  app_password_find(final String phone , final String password ) throws Exception{
		
		Object ret = DbHelper.execute(DataSourceBuilder.getInstance().getDataSource(), new JdbcCallback() {
			
					@Override
					public Object doInJdbc(Connection arg0) throws SQLException, Exception {
						
						final String sqlCom="{call App_update_password_find(?,?,?)}";
						CallableStatement cs = arg0.prepareCall(sqlCom);
						
						cs.setObject(1,phone);
						
						cs.setObject(2,password);
						
						cs.registerOutParameter(3, Types.INTEGER);
						
						cs.execute();// 执行存储过程 
						
						
				        int n = cs.getInt(3); 
				        				        		
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

public  static int  device_setinfo(final ReqBean reqBean) throws Exception{
	Object ret = DbHelper.execute(DataSourceBuilder.getInstance().getDataSource(), new JdbcCallback() {
		
				@Override
				public Object doInJdbc(Connection arg0) throws SQLException, Exception {
					
					final String sqlCom="{call Device_update_info(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
					CallableStatement cs = arg0.prepareCall(sqlCom);
					String code=null;
					cs.setObject(1,reqBean.getDeviceid());
					
					cs.setObject(2,reqBean.getPhone_number());
					cs.setObject(3,reqBean.getDeviceIMEI());
					cs.setObject(4,reqBean.getPhoneIMSI());
					cs.setObject(5,reqBean.getDevicetype());
					cs.setObject(6,reqBean.getVersion());
					cs.setObject(7,reqBean.getProfile_photo());
					cs.setObject(8,reqBean.getNick_name());
					cs.setObject(9,reqBean.getSex());
					cs.setObject(10,reqBean.getDate_birthday());
					cs.setObject(11,reqBean.getGrade());
					cs.setObject(12,reqBean.getHeight());
					cs.setObject(13,reqBean.getWeight());
					cs.setObject(14,reqBean.getHomeAddress());
					cs.setObject(15,reqBean.getSchoolAddress());
				
			        int n = cs.executeUpdate(); // 执行存储过程 
			        
			        		
			        cs.close();
		            
					return n;
				}
		});
	return (int)ret;
			
}

	public  static ReqBean  device_watchinfo(final ReqBean reqBean) throws Exception{
		
		Object ret = DbHelper.execute(DataSourceBuilder.getInstance().getDataSource(), new JdbcCallback() {
		
				@Override
				public Object doInJdbc(Connection arg0) throws SQLException, Exception {
					
					final String sqlCom="{call Device_watch(?,?)}";
					CallableStatement cs = arg0.prepareCall(sqlCom);
					
					cs.setObject(1,reqBean.getDeviceid());
					
					cs.registerOutParameter(2, Types.VARCHAR); // watch_setting
					
					int n = cs.executeUpdate(); // 执行存储过程 
					
					ReqBean resBean =new ReqBean();
					
					Gson gson = new Gson();
					resBean.setWatch_setting(gson.fromJson(cs.getString(2),Watch_setting.class));		        
			        		
			        cs.close();
		            
					return resBean;
				}
			});
		return (ReqBean)ret;
			
	}
	
	public  static int  device_setwatchinfo(final ReqBean reqBean) throws Exception{
		Object ret = DbHelper.execute(DataSourceBuilder.getInstance().getDataSource(), new JdbcCallback() {
			
					@Override
					public Object doInJdbc(Connection arg0) throws SQLException, Exception {
						
						final String sqlCom="{call Device_update_watch(?,?)}";
						CallableStatement cs = arg0.prepareCall(sqlCom);
						String code=null;
						cs.setObject(1,reqBean.getDeviceid());
						Gson gson = new Gson();
						cs.setObject(2,gson.toJson(reqBean.getWatch_setting()));
											
						
				        int n = cs.executeUpdate(); // 执行存储过程 
				                			        		
				        cs.close();
			            
						return n;
					}
			});
		return (int)ret;
				
	}
	
	public  static ReqBean  app_getmessage_other(final ReqBean reqBean) throws Exception{
		
		Object ret = DbHelper.execute(DataSourceBuilder.getInstance().getDataSource(), new JdbcCallback() {
		
				@Override
				public Object doInJdbc(Connection arg0) throws SQLException, Exception {
					
					final String sqlCom="{call Message_find_receive(?)}";
					CallableStatement cs = arg0.prepareCall(sqlCom);
					
					cs.setObject(1,reqBean.getDeviceid());
					
					ResultSet rs = cs.executeQuery(); // 执行存储过程 
					List<MessageBean> list = new LinkedList();
					while(rs.next()) {
						MessageBean messageBean =new MessageBean();
						messageBean.setFromID(rs.getString("c_fromID"));
						messageBean.setContent(rs.getString("c_content"));
						messageBean.setMessage_type(rs.getInt("n_type"));
						messageBean.setVoiceurl(rs.getString("c_voiceurl"));
						list.add(messageBean);
					}
					
					
					Gson gson = new Gson();	        
			        
					rs.close();
			        cs.close();
		            ReqBean res = new ReqBean();
		            res.setMessage(gson.toJson(list));
		            
					return res;
				}
			});
		return (ReqBean)ret;
			
	}
	
	
public  static ReqBean  device_getlocation_latest(final ReqBean reqBean) throws Exception{
		
		Object ret = DbHelper.execute(DataSourceBuilder.getInstance().getDataSource(), new JdbcCallback() {
		
				@Override
				public Object doInJdbc(Connection arg0) throws SQLException, Exception {
					
					final String sqlCom="{call Device_location_latest(?,?,?,?,?)}";
					CallableStatement cs = arg0.prepareCall(sqlCom);
					
					cs.setObject(1,reqBean.getDeviceid());
					
					cs.registerOutParameter(2, Types.INTEGER); // type
					
					cs.registerOutParameter(3, Types.DOUBLE); // lng
					cs.registerOutParameter(4, Types.DOUBLE); // lat
					
					cs.registerOutParameter(5, Types.INTEGER); // time
					
					int n = cs.executeUpdate(); // 执行存储过程 
					
					ReqBean resBean =new ReqBean();
					
					Gson gson = new Gson();
					resBean.setLoctype(cs.getInt(2));		        
					resBean.setLongitude(cs.getDouble(3));
					resBean.setLatitude(cs.getDouble(4));
					resBean.setTime(cs.getInt(5));	
					
			        cs.close();
		            
					return resBean;
				}
			});
		return (ReqBean)ret;
			
	}

public  static ReqBean  device_getlocation_period(final ReqBean reqBean) throws Exception{
	
	Object ret = DbHelper.execute(DataSourceBuilder.getInstance().getDataSource(), new JdbcCallback() {
	
			@Override
			public Object doInJdbc(Connection arg0) throws SQLException, Exception {
				
				final String sqlCom="{call Device_location_period(?,?,?)}";
				CallableStatement cs = arg0.prepareCall(sqlCom);
				
				cs.setObject(1,reqBean.getDeviceid());
				cs.setObject(2,reqBean.getStarttime());
				cs.setObject(3,reqBean.getEndtime());
				
				System.out.println(reqBean.getDeviceid()+"\t"+reqBean.getStarttime()+"\t"+reqBean.getEndtime());
				
				ResultSet rs = cs.executeQuery(); // 执行存储过程 
				List<LocationBean> list = new LinkedList();
				while(rs.next()) {
					LocationBean reqBean =new LocationBean();
					
					reqBean.setLoctype(rs.getInt("n_loctype"));		        
					reqBean.setLongitude(rs.getDouble("n_lng"));
					reqBean.setLatitude(rs.getDouble("n_lat"));
					reqBean.setTime(rs.getInt("n_time"));	
					list.add(reqBean);
				}
				
				
				Gson gson = new Gson();	        
		        
				rs.close();
		        cs.close();
	            ReqBean resp = new ReqBean();
	            
	            resp.setMessage(gson.toJson(list));
	            System.out.println("list"+resp.getMessage());
				return resp;
			}
		});
	return (ReqBean)ret;
		
}

	public  static int  device_setmanageinfo(final ReqBean reqBean) throws Exception{
		Object ret = DbHelper.execute(DataSourceBuilder.getInstance().getDataSource(), new JdbcCallback() {
			
					@Override
					public Object doInJdbc(Connection arg0) throws SQLException, Exception {
						
						final String sqlCom="{call Device_update_manage(?,?)}";
						CallableStatement cs = arg0.prepareCall(sqlCom);
						String code=null;
						cs.setObject(1,reqBean.getDeviceid());
						Gson gson = new Gson();
						cs.setObject(2,gson.toJson(reqBean.getWatch_manage()));
											
						
				        int n = cs.executeUpdate(); // 执行存储过程 
				                			        		
				        cs.close();
			            
						return n;
					}
			});
		return (int)ret;
				
	}
	
public  static ReqBean  device_manageinfo(final ReqBean reqBean) throws Exception{
		
		Object ret = DbHelper.execute(DataSourceBuilder.getInstance().getDataSource(), new JdbcCallback() {
		
				@Override
				public Object doInJdbc(Connection arg0) throws SQLException, Exception {
					
					final String sqlCom="{call Device_manage(?,?)}";
					CallableStatement cs = arg0.prepareCall(sqlCom);
					
					cs.setObject(1,reqBean.getDeviceid());
					
					cs.registerOutParameter(2, Types.VARCHAR); // watch_setting
					
					int n = cs.executeUpdate(); // 执行存储过程 
					
					ReqBean resBean =new ReqBean();
					
					System.out.println("返回值："+cs.getString(2));
					Gson gson = new Gson();
					resBean.setWatch_manage(gson.fromJson(cs.getString(2),Watch_manage.class));		        
			        		
			        cs.close();
		            
					return resBean;
				}
			});
		return (ReqBean)ret;
			
	}

	public  static int  device_setstrangerinfo(final ReqBean reqBean) throws Exception{
		Object ret = DbHelper.execute(DataSourceBuilder.getInstance().getDataSource(), new JdbcCallback() {
			
					@Override
					public Object doInJdbc(Connection arg0) throws SQLException, Exception {
						
						final String sqlCom="{call Device_setting_stranger(?,?)}";
						CallableStatement cs = arg0.prepareCall(sqlCom);
						String code=null;
						cs.setObject(1,reqBean.getDeviceid());
						cs.setObject(2,reqBean.getAnti_stranger_status());
								
						
				        int n = cs.executeUpdate(); // 执行存储过程 
				                			        		
				        cs.close();
			            
						return n;
					}
			});
		return (int)ret;
				
	}
}
