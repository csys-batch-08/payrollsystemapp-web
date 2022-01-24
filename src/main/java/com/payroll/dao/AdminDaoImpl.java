package com.payroll.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import com.payroll.Interface.AdminDao;
import com.payroll.model.Admin;

public class AdminDaoImpl implements AdminDao{
	
	public boolean validateAdmin(Admin admin) {
		
		String query="select EMAIL_ID,PASSWORD from admin_details where email_id = ? and password = ?" ;
		ConnectionUtilImpl connection=new ConnectionUtilImpl();
		Connection con=connection.dbConnect();
		boolean flag=false;
		
		try {
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, admin.getEmailId());
			pstmt.setString(2, admin.getPassword());
			int i=pstmt.executeUpdate();
			if(i>0) {
				flag=true;
			}
			}
		catch (SQLException e) {
			e.printStackTrace();
//			System.out.println("Query not executed correctly");
		}
		return flag  ;
		
		
	}


}
