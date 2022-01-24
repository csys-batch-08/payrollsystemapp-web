package com.payroll.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.payroll.Interface.ConnectionDao;


public class ConnectionUtilImpl implements ConnectionDao{
	public  Connection dbConnect() {
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			
			
			con=DriverManager.getConnection(url,"system","oracle");
			}
		
			catch (SQLException e) {
				e.getMessage();

			}
		 
		catch (ClassNotFoundException e) {
			e.getMessage();
		
		}
		return con;
		
		
		
	}

}
