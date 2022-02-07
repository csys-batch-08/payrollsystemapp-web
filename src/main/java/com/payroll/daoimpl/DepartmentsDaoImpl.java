package com.payroll.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.payroll.dao.DepartmentDao;
import com.payroll.model.Departments;

public class DepartmentsDaoImpl implements DepartmentDao {
	static final String DEPTID="dept_id";
	static final String DEPTNAME="DEPT_NAME";
	static final String STATUS="STATUS";
	
	public int insertDep(Departments dprt)

	{
		String insertQuery = "insert into departments (DEPT_NAME) values (?)";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		int i = 0;
		PreparedStatement preparedStatement = null;
		try {
			 preparedStatement = connection.prepareStatement(insertQuery);
			 preparedStatement.setString(1,dprt.getDeptName());

			i = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		return i;

	}

	public int findDepartmentID(Departments dept) {

		String findId = "select dept_id from departments where dept_name = ?";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		PreparedStatement preparedStatement = null;
		int id = 0;
		ResultSet  resultSet = null;
		try {
			
			preparedStatement = connection.prepareStatement(findId);
			preparedStatement.setString(1, dept.getDeptName());
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				id = resultSet.getInt(DEPTID);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection, resultSet);
			
		}

		return id;
	}

	public int updateDept(Departments depart) {
		String insertQuery = "update departments set dept_name=? where dept_id=?";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		PreparedStatement preparedStatement = null;
		int i = 0;
		try {

			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, depart.getDeptName());
			preparedStatement.setLong(2, depart.getDeptId());
			i = preparedStatement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		return i;

	}

	public boolean deleteDept(int deptId) {
		String deleteQuery = "update departments set status='inactive' where DEPT_ID=?";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		boolean result = false;
		PreparedStatement preparedStatement = null;
		try {

			preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, deptId);
			preparedStatement.executeUpdate();
			result=true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		return result;
	}

	public List<Departments> showDepartments() {
		List<Departments> departmentList = new ArrayList();

		String showQuery = "select DEPT_ID,DEPT_NAME from Departments where status='active'";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		Statement statement = null;
		
		ResultSet resultSet =null;
		try {
			 statement = connection.createStatement();
			resultSet = statement.executeQuery(showQuery);
			while (resultSet.next()) {
				Departments department = new Departments(resultSet.getInt(DEPTID), 
						resultSet.getString(DEPTNAME));
				departmentList.add(department);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closeStatement(statement, connection, resultSet);

		}

		return departmentList;
	}
	public List<Departments> showInactiveDepartments() {
		List<Departments> departmentList = new ArrayList();

		String showQuery = "select DEPT_ID,DEPT_NAME from Departments where status='inactive'";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		Statement statement = null;
		ResultSet resultSet =null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(showQuery);
			while (resultSet.next()) {
				Departments department = new Departments(resultSet.getInt(DEPTID), 
						resultSet.getString(DEPTNAME));
				departmentList.add(department);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closeStatement(statement, connection, resultSet);

		}

		return departmentList;
	}

	public Departments findDepartment(int id) {
		String query = "select DEPT_ID,DEPT_NAME from departments where dept_id=?";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		Departments departments = null;
		ResultSet resultSet =null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			 resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				departments = new Departments(resultSet.getInt(DEPTID), resultSet.getString(DEPTNAME));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return departments;

	}

	public Departments findDepartment(String deptName) {
		String query = "select DEPT_ID,DEPT_NAME from departments where dept_name= ?";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		Departments departments = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, deptName);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {

				departments = new Departments(resultSet.getInt(DEPTID), resultSet.getString(DEPTNAME));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection, resultSet);
		}

		return departments;

	}

	public List<Departments> searchDepartment(String deptName) {
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		String query = "select DEPT_ID,DEPT_NAME,STATUS from departments where upper(DEPT_NAME) like ?";
		ResultSet resultSet = null;
		List<Departments> departmentList = new ArrayList();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, deptName.toUpperCase() + "%");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				Departments department = new Departments(resultSet.getInt(DEPTID), 
						resultSet.getString(DEPTNAME),resultSet.getString(STATUS));
				departmentList.add(department);
			}

			return departmentList;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return departmentList;

	}
	public boolean validateDepartName(Departments department) {
		boolean flag = true;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Connection connection =null;
		try {
			ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
			connection = connectionUtilImpl.dbConnect();
			String query = "select DEPT_NAME from departments where DEPT_NAME=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, department.getDeptName());
		    resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				flag = false;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return flag;
	}
	public int updateStatusActive(Departments departments) {

		String insertQuery = " update departments set STATUS='active' where DEPT_ID= ?";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		int i = 0;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setInt(1, departments.getDeptId());
			i = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		return i;

	}

}
