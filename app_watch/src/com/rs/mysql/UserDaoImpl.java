package com.rs.mysql;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;








import com.tonetime.commons.database.helper.DbHelper;
import com.tonetime.commons.database.helper.JdbcCallback;


/**
 * 从数据库查询数据
 */
public class UserDaoImpl{
	
	/**
	 * 登陆验证
	 */
	public  static List checkLogin(final String un,final String pw) throws Exception{
			
			List<Map<String,Object>> list = (List<Map<String, Object>>) DbHelper.execute(DataSourceBuilder.getInstance().getDataSource(), new JdbcCallback() {
				
						@Override
						public Object doInJdbc(Connection arg0) throws SQLException, Exception {
							
							final String sqlCom="select * from user_login where username='"+un+"' and password='"+pw+"' ";
							return DbHelper.queryForList(arg0, sqlCom);
						}
					});
			
			return list;
			
	}
	
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
	
public  static String  verifycode_find(final String id) throws Exception{
		
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
			            
			            System.out.println("code:"+code);
						return sqlCom;
					}
				});
		return ret;		
	}
	
	
}
