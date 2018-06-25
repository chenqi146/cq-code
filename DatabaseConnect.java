package com.cqmike.connect.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnect {
	
	
	
		
		private static String username="root";
		private static String password="cqmikecq";
		private static String url="jdbc:mysql://localhost:3306/studentdata?useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC ";
		ResultSet rs =null;
		static Connection connection = null;
		
//		public DatabaseConnect() {
//			try {
//				//mysql数据库设置驱动程序类型
//				Class.forName("com.mysql.jdbc.Driver"); 
//				System.out.println("mysql数据库驱动加载成功");
//1
//			}
//			catch(java.lang.ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//		}
//		
		public static Connection getConnection() {
			// TODO Auto-generated method stub
//			ResultSet resultSet=null;
//			Connection connection=null;
			try{
				connection=DriverManager.getConnection(url,username,password);
			}catch(Exception e)
			{
				if(connection==null) 
					e.printStackTrace();
			}
			return connection;
		}

		
		public static void disConnection(Connection connection)
		{
			try{
				connection.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		public ResultSet executeQuery(String sql) {
			
			
			
			try {
				System.out.println("executeQuery(). sql = " + sql);
//				if(connection);
				PreparedStatement pstm = connection.prepareStatement(sql);
				// 执行查询
				rs = pstm.executeQuery();
			} 
			catch(SQLException ex) { 
				ex.printStackTrace();
			}
			return rs;
		}
		
		//插入
		//executeUpdate 的返回值是一个整数，指示受影响的行数（即更新计数）。
		//executeUpdate用于执行 INSERT、UPDATE 或 DELETE 语句
		//以及 SQL DDL（数据定义语言）语句，例如 CREATE TABLE 和 DROP TABLE。
		
		//执行增、删、改语句的方法
		public int executeUpdate(String sql) {
			int count = 0;
			Connection connection = null;
			connection = getConnection();
			try {
				Statement stmt = connection.createStatement();
				count = stmt.executeUpdate(sql);
			} 
			catch(SQLException ex) { 
				System.err.println(ex.getMessage());		
			}
			disConnection(getConnection());
			return count;
		}
//		public static void main() {
//			
//		}




}
