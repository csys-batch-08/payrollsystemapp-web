package com.payroll.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.payroll.daoimpl.ConnectionDao;


public class ConnectionUtilImpl implements ConnectionDao{
	public  Connection dbConnect() {
		Connection connection=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			
			
			connection=DriverManager.getConnection(url,"system","oracle");
			
			}
		
			catch (SQLException e) {
				
				e.printStackTrace();
				

			}
		 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		}
		return connection;
		
	}
	public static  void closePreparedStatement(PreparedStatement preparedStatement,Connection connection) {
		try {
			if(preparedStatement!=null) {
		
				preparedStatement.close();
			}if(connection!=null) {
				connection.close();
			}
			
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	public static void closeStatement (Statement statement,Connection connection) {
		try {
			if(statement!=null) {
			
				statement.close();
			}
			if(connection!=null) {
				connection.close();
			}
			
			
			
		} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	
	

}
