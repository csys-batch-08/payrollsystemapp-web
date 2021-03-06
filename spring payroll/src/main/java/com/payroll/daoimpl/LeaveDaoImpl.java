package com.payroll.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.payroll.model.Employee;
import com.payroll.model.Leave;

@Repository
public class LeaveDaoImpl {
	static final String LEAVEID="LEAVE_ID";
	static final String EMPID="EMP_ID";
	static final String LEAVEDATE="LEAVE_DATE";
	static final String REASON="REASON";
	static final String LEAVECOUNT="leave_count";


	public boolean insertLeave(Leave leave) {
		String query = "insert into leave_details (emp_id,leave_date,reason) values (?,?,?)";
		boolean result = false;
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			int empId = employeeDaoImpl.findEmployeeID(leave.getEmploy());
			preparedStatement.setInt(1, empId);
			preparedStatement.setDate(2, new java.sql.Date(leave.getLeaveDt().getTime()));
			preparedStatement.setString(3, leave.getLeaveReason());
			preparedStatement.executeUpdate();
			result = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		return result;

	}

	public List<Leave> showLeaveDetail() {
		List<Leave> leaveList = new ArrayList<Leave>();

		String showQuery = "select LEAVE_ID,EMP_ID,LEAVE_DATE,REASON from leave_details";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		ResultSet resultSet =null;
		Connection connection = connectionUtilImpl.dbConnect();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(showQuery);
			while (resultSet.next()) {
				Employee employ = employeeDaoImpl.findEmployee(resultSet.getInt(EMPID));

				Leave leave = new Leave(resultSet.getInt(LEAVEID), employ, resultSet.getDate(LEAVEDATE),
						resultSet.getString(REASON));
				leaveList.add(leave);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closeStatement(statement, connection, resultSet);
		}

		return leaveList;
	}

	public int findLeaveID(Leave leave)

	{

		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();

		int empID = employeeDaoImpl.findEmployeeID(leave.getEmploy());

		String findId = "select leave_id from leave_details where EMP_ID = ? and leave_date = ? ";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		PreparedStatement preparedStatement = null;
		int id = 0;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(findId);
			preparedStatement.setInt(1, empID);
			preparedStatement.setDate(2, new java.sql.Date(leave.getLeaveDt().getTime()));

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				id = resultSet.getInt(LEAVEID);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return id;
	}

	public Leave findLeave(Date leaveDt, int empId) {

		String qry = "select LEAVE_ID,EMP_ID,LEAVE_DATE,REASON from leave_details "
				+ "where LEAVE_DATE = ? and emp_id =  ?";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		ResultSet resultSet = null;
		Leave leave = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(qry);
			preparedStatement.setDate(1, new java.sql.Date(leaveDt.getTime()));
			EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();

			preparedStatement.setInt(2, empId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee emp = employeeDaoImpl.findEmployee(resultSet.getInt(EMPID));
				leave = new Leave(emp, resultSet.getDate(LEAVEDATE), resultSet.getString(REASON));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection, resultSet);
		}

		return leave;

	}

	public int leaveDays(int empID) {
		String query = "select count(leave_id) as leave_count from leave_details where emp_id=?" 
				+ "group by emp_id";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		int count = 0;
		PreparedStatement  preparedStatement=null;
		ResultSet resultSet = null;

		try {
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, empID);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				count = resultSet.getInt(LEAVECOUNT);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection, resultSet);
		}

		return count;

	}

	public Leave findLeave(int leaveId) {

		String qry = "select LEAVE_ID,EMP_ID,LEAVE_DATE,REASON from Leave_details where leave_id = ?" ;
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		PreparedStatement preparedStatement=null;
		Leave leave = null;
		try {
			preparedStatement = connection.prepareStatement(qry);
			preparedStatement.setInt(1, leaveId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee emp = employeeDaoImpl.findEmployee(resultSet.getInt(EMPID));
				leave = new Leave(resultSet.getInt(LEAVEID), emp, resultSet.getDate(LEAVEDATE),
						resultSet.getString(REASON));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}

		return leave;

	}

	public int deleteLeave(Leave leave) {
		String query = "delete from leave_details where LEAVE_ID =?";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		PreparedStatement preparedStatement = null;
		int i = 0;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, leave.getLeaveId());
			i = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		return i;

	}

	public int updateLeave(Leave leave) {
		String query = "update leave_details set LEAVE_DATE=?,REASON=? where LEAVE_ID=?";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		PreparedStatement preparedStatement = null;
		int i = 0;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDate(1, new java.sql.Date(leave.getLeaveDt().getTime()));
			preparedStatement.setString(2, leave.getLeaveReason());
			preparedStatement.setInt(3, leave.getLeaveId());
			i = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		return i;

	}

	public List<Leave> searchLeave(Date fromDt, Date toDate) {
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		String searchQuery = "select LEAVE_ID,EMP_ID,LEAVE_DATE,REASON from leave_details "
				+ "where LEAVE_DATE  between ? and ?";
		List<Leave> leaveList = new ArrayList();
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(searchQuery);
			preparedStatement.setDate(1, new java.sql.Date(fromDt.getTime()));
			preparedStatement.setDate(2, new java.sql.Date(toDate.getTime()));
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				EmployeeDaoImpl employDao = new EmployeeDaoImpl();
				Employee employ = employDao.findEmployee(resultSet.getInt(EMPID));
				Leave leave = new Leave(resultSet.getInt(LEAVEID), employ, resultSet.getDate(LEAVEDATE), 
						resultSet.getString(REASON));
				leaveList.add(leave);

			}
			return leaveList;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);

		}

		return leaveList;

	}

}
