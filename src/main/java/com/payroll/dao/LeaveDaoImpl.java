package com.payroll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.payroll.model.Employee;
import com.payroll.model.Leave;

public class LeaveDaoImpl {
	public boolean insertLeave(Leave leave) {
		String query="insert into leave_details (emp_id,leave_date,reason) values (?,?,?)";
		boolean result=false;
		ConnectionUtilImpl connection=new ConnectionUtilImpl();
		Connection con=connection.dbConnect();
		EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
		PreparedStatement pstmt=null;
		try {
			pstmt=con.prepareStatement(query);
			int empId=employeeDaoImpl.findEmployeeID(leave.getEmploy());
			pstmt.setInt(1, empId);
			pstmt.setDate(2, new java.sql.Date(leave.getLeaveDt().getTime()));
			pstmt.setString(3, leave.getLeaveReason());
			pstmt.executeUpdate();
			result=true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(pstmt, con);
		}
		return result;
		
		
	}
	
	public List<Leave> showLeaveDetail()
	{
		List<Leave> leaveList=new ArrayList<Leave>();
		
		String showQuery="select LEAVE_ID,EMP_ID,LEAVE_DATE,REASON from leave_details";
		ConnectionUtilImpl connection=new ConnectionUtilImpl();
		EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();

		Connection con=connection.dbConnect();
		Statement stmt=null;
		try {
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(showQuery);
			while(rs.next())
			{
				Employee employ=employeeDaoImpl.findEmployee(rs.getInt(2));
				
				Leave leave=new Leave(rs.getInt(1),employ,rs.getDate(3),rs.getString(4));
				leaveList.add(leave);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closeStatement(stmt, con);
		}
		
		
		return leaveList;
	}
	public  int findLeaveID(Leave leave)
	
	{	
		
		EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();

		int empID=employeeDaoImpl.findEmployeeID(leave.getEmploy());
		
		String findId="select leave_id from leave_details where EMP_ID = ? and leave_date = ? ";
		ConnectionUtilImpl connection=new ConnectionUtilImpl();
		Connection con=connection.dbConnect();
		PreparedStatement pstmt=null;
		int id = 0;
		try {
			pstmt=con.prepareStatement(findId);
			pstmt.setInt(1, empID);
			pstmt.setDate(2, new java.sql.Date(leave.getLeaveDt().getTime()));
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				id=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(pstmt, con);
		}
		return id;
	}
	public  Leave findLeave(Date leaveDt,int empId) {
		
		String qry="select LEAVE_ID,EMP_ID,LEAVE_DATE,REASON from leave_details where LEAVE_DATE = ? and emp_id =  ?";
		ConnectionUtilImpl connection=new ConnectionUtilImpl();
		Connection con=connection.dbConnect();
		
		Leave leave=null;
		PreparedStatement pstmt=null;
		try {
			pstmt=con.prepareStatement(qry);
			pstmt.setDate(1, new java.sql.Date(leaveDt.getTime()));
			EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();

			pstmt.setInt(2, empId); 
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Employee emp=employeeDaoImpl.findEmployee(rs.getInt(2));
				 leave=new Leave(emp,rs.getDate(3),rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(pstmt, con);
		}
		
		return leave;
		
	}
	public  int leaveDays(int empID) {
	String query="select count(leave_id) as leave_count from leave_details where emp_id="+empID +"group by emp_id";
	ConnectionUtilImpl connection=new ConnectionUtilImpl();
	Connection con=connection.dbConnect();
	int count=0;
	Statement stmt=null;

	try {
		stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		if(rs.next()) {
			count=rs.getInt(1);
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		ConnectionUtilImpl.closeStatement(stmt, con);
	}
	
	return count;
		
	}
public  Leave findLeave(int leaveId) {
		
		String qry="select LEAVE_ID,EMP_ID,LEAVE_DATE,REASON from Leave_details where leave_id = "+leaveId;
		ConnectionUtilImpl connection=new ConnectionUtilImpl();
		Connection con=connection.dbConnect();
		EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl();
		Statement stmt=null;
		Leave leave=null;
		try {
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(qry);
			while(rs.next()) {
				Employee emp=employeeDaoImpl.findEmployee(rs.getInt(2));
				 leave=new Leave(rs.getInt(1),emp,rs.getDate(3),rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closeStatement(stmt, con);
		}
		
		return leave;
		
	}
public int deleteLeave(Leave leave) {
	String query="delete from leave_details where LEAVE_ID =?";
	ConnectionUtilImpl connection=new ConnectionUtilImpl();
	Connection con=connection.dbConnect();
	PreparedStatement pstmt=null;
	int i=0;
	try {
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1, leave.getLeaveId());
		i=pstmt.executeUpdate();

	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		ConnectionUtilImpl.closePreparedStatement(pstmt, con);
	}
	return i;
	
}
public int updateLeave(Leave leave) {
	String query="update leave_details set LEAVE_DATE=?,REASON=? where LEAVE_ID=?";
	ConnectionUtilImpl connection=new ConnectionUtilImpl();
	Connection con=connection.dbConnect();
	PreparedStatement pstmt=null;
	int i=0;
	try {
		pstmt = con.prepareStatement(query);
		pstmt.setDate(1, new java.sql.Date(leave.getLeaveDt().getTime()));
		pstmt.setString(2, leave.getLeaveReason());
		pstmt.setInt(3, leave.getLeaveId());
		i=pstmt.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		ConnectionUtilImpl.closePreparedStatement(pstmt, con);
	}
	return i;
	
	
}
public List<Leave> searchLeave(Date fromDt,Date toDate){
	ConnectionUtilImpl connection=new ConnectionUtilImpl();
	Connection con=connection.dbConnect();
	String searchQuery="select LEAVE_ID,EMP_ID,LEAVE_DATE,REASON from leave_details where LEAVE_DATE  between ? and ?";
	List<Leave> leaveList=new ArrayList<Leave>();
	ResultSet rs=null;
	PreparedStatement pstmt=null;
	try {
		pstmt=con.prepareStatement(searchQuery);
		pstmt.setDate(1,new java.sql.Date (fromDt.getTime()));
		pstmt.setDate(2,new java.sql.Date(toDate.getTime()));
		rs=pstmt.executeQuery();
		while(rs.next()) {
			EmployeeDaoImpl employDao=new EmployeeDaoImpl();
			Employee employ=employDao.findEmployee(rs.getInt(2));
			Leave leave=new Leave(rs.getInt(1),employ,rs.getDate(3),rs.getString(4));
			leaveList.add(leave);
			
		}
		return leaveList;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		ConnectionUtilImpl.closePreparedStatement(pstmt, con);
		
	}
	
	return leaveList;
	
}

}
