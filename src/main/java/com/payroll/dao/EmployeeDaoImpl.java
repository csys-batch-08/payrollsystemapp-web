package com.payroll.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.payroll.Interface.EmployeeDao;

import com.payroll.model.Departments;
import com.payroll.model.Employee;
import com.payroll.model.Grade;

public class EmployeeDaoImpl implements EmployeeDao {
	public boolean insertEmp(Employee emp) {
		boolean result = false;
		String insertQuery = "insert into employees (emp_name,emp_dob,emp_doj,emp_address,emp_city,emp_pincode,emp_mobile_no,"
				+ "emp_state,emp_email_id,emp_pan_no,dept_id,GRADE_ID) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(insertQuery);

			preparedStatement.setString(1, emp.getEmpName());
			preparedStatement.setDate(2, new java.sql.Date(emp.getDob().getTime()));
			preparedStatement.setDate(3, new java.sql.Date(emp.getDoj().getTime()));
			preparedStatement.setString(4, emp.getAddress());
			preparedStatement.setString(5, emp.getCity());
			preparedStatement.setLong(6, emp.getPincode());
			preparedStatement.setLong(7, emp.getMobileNo());
			preparedStatement.setString(8, emp.getState());
			preparedStatement.setString(9, emp.getMailId());
			preparedStatement.setString(10, emp.getPanNo());
			preparedStatement.setInt(11, emp.getDept().getDeptId());
			preparedStatement.setInt(12, emp.getGrade().getGradeId());
			result = preparedStatement.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		return result;

	}

	public Employee findEmployee(int empId) {
		String findEmployeeQuery = "select EMP_ID,EMP_NAME,EMP_DOB,EMP_DOJ,EMP_ADDRESS,EMP_CITY,EMP_PINCODE,EMP_MOBILE_NO,EMP_STATE,EMP_EMAIL_ID,EMP_PAN_NO,DEPT_ID,GRADE_ID,STATUS from employees where emp_id=?";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		Employee employee = null;
		DepartmentsDaoImpl deptDao = new DepartmentsDaoImpl();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(findEmployeeQuery);
			preparedStatement.setInt(1, empId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				GradeDaoImpl gradeDao = new GradeDaoImpl();
				Grade grade = gradeDao.findGrade(resultSet.getInt(13));
				Departments dept = deptDao.findDepartment(resultSet.getInt(12));
				employee = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getDate(3), resultSet.getDate(4), resultSet.getString(5),
						resultSet.getString(6), resultSet.getLong(7), resultSet.getLong(8), resultSet.getString(9), resultSet.getString(10),
						resultSet.getString(11), dept, grade);
			}
			return employee;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		return employee;
	}

	public int updateEmp(Employee employ) {

		String insertQuery = " update employees set EMP_NAME=?,EMP_DOB=?,EMP_DOJ=?,EMP_ADDRESS=?,EMP_CITY=?,EMP_PINCODE=?,EMP_MOBILE_NO=?,EMP_STATE=?,EMP_EMAIL_ID=?,EMP_PAN_NO=? ,DEPT_ID=?,GRADE_ID=?where emp_id= ?";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		int i = 0;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, employ.getEmpName());
			preparedStatement.setDate(2, new java.sql.Date(employ.getDob().getTime()));
			preparedStatement.setDate(3, new java.sql.Date(employ.getDoj().getTime()));
			preparedStatement.setString(4, employ.getAddress());
			preparedStatement.setString(5, employ.getCity());
			preparedStatement.setLong(6, employ.getPincode());
			preparedStatement.setLong(7, employ.getMobileNo());
			preparedStatement.setString(8, employ.getState());
			preparedStatement.setString(9, employ.getMailId());
			preparedStatement.setString(10, employ.getPanNo());
			preparedStatement.setInt(11, employ.getDept().getDeptId());
			preparedStatement.setInt(12, employ.getGrade().getGradeId());
			preparedStatement.setInt(13, employ.getEmpId());

			i = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		return i;

	}

	public int deleteEmp(int empId) {
		String deleteQuery = "delete from employees where EMP_ID=?";

		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		int i = 0;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, empId);
			i = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		return i;

	}

	public int findEmployeeID(Employee emp) {
		String findId = "select emp_id from employees where emp_email_id= '" + emp.getMailId() + "'";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		Statement statement = null;
		int id = 0;
		try {
			statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(findId);
			if (resultSet.next()) {
				id = resultSet.getInt(1);
				return id;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closeStatement(statement, connection);
		}

		return id;
	}

	public List<Employee> showEmployee() {
		List<Employee> employeeList = new ArrayList<Employee>();

		String showQuery = "select  EMP_ID,EMP_NAME,EMP_DOB,EMP_DOJ,EMP_ADDRESS,EMP_CITY,EMP_PINCODE,EMP_MOBILE_NO,EMP_STATE,EMP_EMAIL_ID,EMP_PAN_NO,DEPT_ID,GRADE_ID,STATUS  from employees where status = 'active' ";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		DepartmentsDaoImpl deptDao = new DepartmentsDaoImpl();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(showQuery);
			while (resultSet.next()) {
				GradeDaoImpl gradeDao = new GradeDaoImpl();
				Grade grade = gradeDao.findGrade(resultSet.getInt(13));
				Departments depart = deptDao.findDepartment(resultSet.getInt(12));
				Employee employee = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getDate(3), resultSet.getDate(4),
						resultSet.getString(5), resultSet.getString(6), resultSet.getLong(7), resultSet.getLong(8), resultSet.getString(9),
						resultSet.getString(10), resultSet.getString(11), depart, grade);
				employeeList.add(employee);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closeStatement(statement, connection);
		}

		return employeeList;
	}

	public List<Employee> showInactiveEmployee() {
		List<Employee> employeeList = new ArrayList<Employee>();

		String showQuery = "select  EMP_ID,EMP_NAME,EMP_DOB,EMP_DOJ,EMP_ADDRESS,EMP_CITY,EMP_PINCODE,EMP_MOBILE_NO,EMP_STATE,EMP_EMAIL_ID,EMP_PAN_NO,DEPT_ID,GRADE_ID,STATUS  from employees where status= 'inactive' ";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		DepartmentsDaoImpl deptDao = new DepartmentsDaoImpl();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(showQuery);
			while (resultSet.next()) {
				GradeDaoImpl gradeDao = new GradeDaoImpl();
				Grade grade = gradeDao.findGrade(resultSet.getInt(13));
				Departments depart = deptDao.findDepartment(resultSet.getInt(12));
				Employee employee = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getDate(3), resultSet.getDate(4),
						resultSet.getString(5), resultSet.getString(6), resultSet.getLong(7), resultSet.getLong(8), resultSet.getString(9),
						resultSet.getString(10), resultSet.getString(11), depart, grade);
				employeeList.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closeStatement(statement, connection);
		}
		return employeeList;
	}

	public Employee findEmploy(String email) {
		String findEmployeeQuery = "select  EMP_ID,EMP_NAME,EMP_DOB,EMP_DOJ,EMP_ADDRESS,EMP_CITY,EMP_PINCODE,EMP_MOBILE_NO,EMP_STATE,EMP_EMAIL_ID,EMP_PAN_NO,DEPT_ID,GRADE_ID,STATUS  from employees where EMP_EMAIL_ID=?";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		DepartmentsDaoImpl deptDao = new DepartmentsDaoImpl();

		Employee employee = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(findEmployeeQuery);
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				GradeDaoImpl gradeDao = new GradeDaoImpl();
				Grade grade = gradeDao.findGrade(resultSet.getInt(13));
				Departments dept = deptDao.findDepartment(resultSet.getInt(12));
				employee = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getDate(3), resultSet.getDate(4), resultSet.getString(5),
						resultSet.getString(6), resultSet.getLong(7), resultSet.getLong(8), resultSet.getString(9), resultSet.getString(10),
						resultSet.getString(11), dept, grade);
			}

		} catch (SQLException e) {

			e.getMessage();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		return employee;
	}

	public void deleteEmp(String email) {
		String deleteQuery = "delete from employees where EMP_EMAIL_ID='" + email + "'";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(deleteQuery);

		} catch (Exception e) {
			e.getMessage();
		} finally {
			ConnectionUtilImpl.closeStatement(statement, connection);
		}
	}

	public int updateEmpStatus(Employee employ) {

		String insertQuery = " update employees set STATUS='inactive' where emp_id= ?";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		PreparedStatement preparedStatement = null;
		int i = 0;
		try {
			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setInt(1, employ.getEmpId());
			i = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		return i;

	}

	public int updateStatusActive(Employee employ) {

		String insertQuery = " update employees set STATUS='active' where emp_id= ?";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		int i = 0;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setInt(1, employ.getEmpId());
			i = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		return i;

	}
	public List<Employee> searchEmployee(String empName) {
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		String query = "select  EMP_ID,EMP_NAME,EMP_DOB,EMP_DOJ,EMP_ADDRESS,EMP_CITY,EMP_PINCODE,EMP_MOBILE_NO,EMP_STATE,EMP_EMAIL_ID,EMP_PAN_NO,DEPT_ID,GRADE_ID,STATUS  from employees where upper(EMP_NAME) like ?";
		ResultSet resultSet = null;
		List<Employee> employeeList = new ArrayList<Employee>();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, empName.toUpperCase() +"%");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				GradeDaoImpl gradeDao = new GradeDaoImpl();
				Grade grade = gradeDao.findGrade(resultSet.getInt(13));
				DepartmentsDaoImpl departDao = new DepartmentsDaoImpl();
				Departments department = departDao.findDepartment(resultSet.getInt(12));
				Employee employ = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getDate(3), resultSet.getDate(4),
						resultSet.getString(5), resultSet.getString(6), resultSet.getLong(7), resultSet.getLong(8), resultSet.getString(9),
						resultSet.getString(10), resultSet.getString(11), department, grade, resultSet.getString(14));
				employeeList.add(employ);
			}

			return employeeList;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		return employeeList;

	}

	public String employStatus(int empId) {

		String query = "select status from employees where emp_id=?";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		String status = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, empId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				status = resultSet.getString(1);
			}
			return status;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);

		}

		return status;

	}

	public Date todayDate() {

		String query = "select sysdate from dual";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		Date today = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				today = resultSet.getDate(1);
			}
			return today;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}

		return today;

	}

	public Employee findEmploy(int deptId, int grdId) {
		String findEmployeeQuery = "select  EMP_ID,EMP_NAME,EMP_DOB,EMP_DOJ,EMP_ADDRESS,EMP_CITY,EMP_PINCODE,EMP_MOBILE_NO,EMP_STATE,EMP_EMAIL_ID,EMP_PAN_NO,DEPT_ID,GRADE_ID,STATUS  from employees where DEPT_ID=? and GRADE_ID=?";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		DepartmentsDaoImpl deptDao = new DepartmentsDaoImpl();

		Employee employee = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(findEmployeeQuery);
			preparedStatement.setInt(1, deptId);
			preparedStatement.setInt(2, grdId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Departments dept = deptDao.findDepartment(resultSet.getInt(12));
				GradeDaoImpl gradeDao = new GradeDaoImpl();
				Grade grade = gradeDao.findGrade(grdId);
				employee = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getDate(3), resultSet.getDate(4), resultSet.getString(5),
						resultSet.getString(6), resultSet.getLong(7), resultSet.getLong(8), resultSet.getString(9), resultSet.getString(10),
						resultSet.getString(11), dept, grade, resultSet.getString(14));
			}

		} catch (SQLException e) {

			e.getMessage();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		return employee;
	}

}
