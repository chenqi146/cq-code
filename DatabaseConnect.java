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
//				//mysql���ݿ�����������������
//				Class.forName("com.mysql.jdbc.Driver"); 
//				System.out.println("mysql���ݿ��������سɹ�");
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
				// ִ�в�ѯ
				rs = pstm.executeQuery();
			} 
			catch(SQLException ex) { 
				ex.printStackTrace();
			}
			return rs;
		}
		
		//����
		//executeUpdate �ķ���ֵ��һ��������ָʾ��Ӱ��������������¼�������
		//executeUpdate����ִ�� INSERT��UPDATE �� DELETE ���
		//�Լ� SQL DDL�����ݶ������ԣ���䣬���� CREATE TABLE �� DROP TABLE��
		
		//ִ������ɾ�������ķ���
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
