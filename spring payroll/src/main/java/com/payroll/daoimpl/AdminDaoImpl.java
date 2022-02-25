package com.payroll.daoimpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.payroll.model.Admin;

import logger.Logger;

@Repository
public class AdminDaoImpl {
	
	
	public boolean validateAdmin(Admin admin) {
		
		String query="select EMAIL_ID,PASSWORD from admin_details where email_id = ? and password = ?" ;
		ConnectionUtilImpl connectionUtilImpl=new ConnectionUtilImpl();
		Connection connection=connectionUtilImpl.dbConnect();
		PreparedStatement preparedStatement=null;
		boolean flag=false;
		
		try {
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, admin.getEmailId());
			preparedStatement.setString(2, admin.getPassword());
			int i=preparedStatement
					.executeUpdate();
			if(i>0) {
				flag=true;
			}
			}
		catch (SQLException e) {
			
			Logger.printStackTrace(e);
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		
		return flag  ;
		
		
	}


}
