package com.payroll.daoimpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.payroll.dao.EmployeeDao;
import com.payroll.model.Departments;
import com.payroll.model.Employee;
import com.payroll.model.Grade;

public class EmployeeDaoImpl implements EmployeeDao {
	static final String EMPID="EMP_ID";
	static final String EMPNAME="EMP_NAME";
	static final String EMPDOB="EMP_DOB";
	static final String EMPDOJ="EMP_DOJ";
	static final String EMPADDRESS="EMP_ADDRESS";
	static final String EMPCITY="EMP_CITY";
	static final String EMPPINCODE="EMP_PINCODE";
	static final String EMPMOBILENO="EMP_MOBILE_NO";
	static final String EMPSTATE="EMP_STATE";
	static final String EMPEMAILID="EMP_EMAIL_ID";
	static final String EMPPANNO="EMP_PAN_NO";
	static final String DEPTID="DEPT_ID";
	static final String GRADEID="GRADE_ID";
	static final String STATUS="STATUS";
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
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(findEmployeeQuery);
			preparedStatement.setInt(1, empId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				GradeDaoImpl gradeDao = new GradeDaoImpl();
				Grade grade = gradeDao.findGrade(resultSet.getInt(GRADEID));
				Departments dept = deptDao.findDepartment(resultSet.getInt(DEPTID));
				employee = new Employee(resultSet.getInt(EMPID), resultSet.getString(EMPNAME), resultSet.getDate(EMPDOB), resultSet.getDate(EMPDOJ), resultSet.getString(EMPADDRESS),
						resultSet.getString(EMPCITY), resultSet.getLong(EMPPINCODE), resultSet.getLong(EMPMOBILENO), resultSet.getString(EMPSTATE), resultSet.getString(EMPEMAILID),
						resultSet.getString(EMPPANNO), dept, grade);
			}
			return employee;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return employee;
	}

	public int updateEmp(Employee employ) {

		String insertQuery = "update employees set EMP_NAME=?,EMP_DOB=?,EMP_DOJ=?,EMP_ADDRESS=?,EMP_CITY=?,EMP_PINCODE=?,EMP_MOBILE_NO=?,EMP_STATE=?,EMP_EMAIL_ID=?,EMP_PAN_NO=? ,DEPT_ID=?,GRADE_ID=?where emp_id= ?";
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
		ResultSet resultSet =null;
		try {
			statement = connection.createStatement();

			resultSet = statement.executeQuery(findId);
			if (resultSet.next()) {
				id = resultSet.getInt(EMPID);
				return id;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closeStatement(statement, connection, resultSet);
		}

		return id;
	}

	public List<Employee> showEmployee() {
		List<Employee> employeeList = new ArrayList();

		String showQuery = "select  EMP_ID,EMP_NAME,EMP_DOB,EMP_DOJ,EMP_ADDRESS,EMP_CITY,EMP_PINCODE,"
				+ "EMP_MOBILE_NO,EMP_STATE,EMP_EMAIL_ID,EMP_PAN_NO,DEPT_ID,GRADE_ID,STATUS "
				+ " from employees where status = 'active' ";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		DepartmentsDaoImpl deptDao = new DepartmentsDaoImpl();
		Statement statement = null;
		ResultSet resultSet =null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(showQuery);
			while (resultSet.next()) {
				GradeDaoImpl gradeDao = new GradeDaoImpl();
				Grade grade = gradeDao.findGrade(resultSet.getInt(GRADEID));
				Departments depart = deptDao.findDepartment(resultSet.getInt(DEPTID));
				Employee employee = new Employee(resultSet.getInt(EMPID), resultSet.getString(EMPNAME),
						resultSet.getDate(EMPDOB), resultSet.getDate(EMPDOJ),
						resultSet.getString(EMPADDRESS), resultSet.getString(EMPCITY),
						resultSet.getLong(EMPPINCODE), resultSet.getLong(EMPMOBILENO), 
						resultSet.getString(EMPSTATE),
						resultSet.getString(EMPEMAILID), resultSet.getString(EMPPANNO), depart, grade);
				employeeList.add(employee);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closeStatement(statement, connection, resultSet);
		}

		return employeeList;
	}

	public List<Employee> showInactiveEmployee() {
		List<Employee> employeeList = new ArrayList();

		String showQuery = "select  EMP_ID,EMP_NAME,EMP_DOB,EMP_DOJ,EMP_ADDRESS,"
				+ "EMP_CITY,EMP_PINCODE,EMP_MOBILE_NO,EMP_STATE,EMP_EMAIL_ID,EMP_PAN_NO,"
				+ "DEPT_ID,GRADE_ID,STATUS  from employees where status= 'inactive' ";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		DepartmentsDaoImpl deptDao = new DepartmentsDaoImpl();
		Statement statement = null;
		ResultSet resultSet =null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(showQuery);
			while (resultSet.next()) {
				GradeDaoImpl gradeDao = new GradeDaoImpl();
				Grade grade = gradeDao.findGrade(resultSet.getInt(GRADEID));
				Departments depart = deptDao.findDepartment(resultSet.getInt(DEPTID));
				Employee employee = new Employee(resultSet.getInt(EMPID), resultSet.getString(EMPNAME),
						resultSet.getDate(EMPDOB), resultSet.getDate(EMPDOJ),
						resultSet.getString(EMPADDRESS), resultSet.getString(EMPCITY),
						resultSet.getLong(EMPPINCODE), resultSet.getLong(EMPMOBILENO),
						resultSet.getString(EMPSTATE),
						resultSet.getString(EMPEMAILID), resultSet.getString(EMPPANNO), depart, grade);
				employeeList.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closeStatement(statement, connection, resultSet);
		}
		return employeeList;
	}

	public Employee findEmploy(String email) {
		String findEmployeeQuery = "select  EMP_ID,EMP_NAME,EMP_DOB,EMP_DOJ,EMP_ADDRESS,"
				+ "EMP_CITY,EMP_PINCODE,EMP_MOBILE_NO,EMP_STATE,EMP_EMAIL_ID,EMP_PAN_NO,DEPT_ID,"
				+ "GRADE_ID,STATUS  from employees where EMP_EMAIL_ID=?";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		DepartmentsDaoImpl deptDao = new DepartmentsDaoImpl();

		Employee employee = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(findEmployeeQuery);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				GradeDaoImpl gradeDao = new GradeDaoImpl();
				Grade grade = gradeDao.findGrade(resultSet.getInt(GRADEID));
				Departments dept = deptDao.findDepartment(resultSet.getInt(DEPTID));
				employee = new Employee(resultSet.getInt(EMPID), resultSet.getString(EMPNAME),
						resultSet.getDate(EMPDOB), resultSet.getDate(EMPDOJ), resultSet.getString(EMPADDRESS),
						resultSet.getString(EMPCITY), resultSet.getLong(EMPPINCODE), resultSet.getLong(EMPMOBILENO),
						resultSet.getString(EMPSTATE), resultSet.getString(EMPEMAILID),
						resultSet.getString(EMPPANNO), dept, grade);
			}

		} catch (SQLException e) {

			e.getMessage();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return employee;
	}

	public void deleteEmp(String email) {
		String deleteQuery = "delete from employees where EMP_EMAIL_ID=?";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setString(1, email);
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.getMessage();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
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
		String query = "select  EMP_ID,EMP_NAME,EMP_DOB,EMP_DOJ,EMP_ADDRESS,EMP_CITY,EMP_PINCODE,"
				+ "EMP_MOBILE_NO,EMP_STATE,EMP_EMAIL_ID,EMP_PAN_NO,DEPT_ID,GRADE_ID,STATUS  "
				+ "from employees where upper(EMP_NAME) like ?";
		ResultSet resultSet = null;
		List<Employee> employeeList = new ArrayList();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, empName.toUpperCase() +"%");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				GradeDaoImpl gradeDao = new GradeDaoImpl();
				Grade grade = gradeDao.findGrade(resultSet.getInt(GRADEID));
				DepartmentsDaoImpl departDao = new DepartmentsDaoImpl();
				Departments department = departDao.findDepartment(resultSet.getInt(DEPTID));
				Employee employ = new Employee(resultSet.getInt(EMPID), resultSet.getString(EMPNAME), 
						resultSet.getDate(EMPDOB), resultSet.getDate(EMPDOJ),
						resultSet.getString(EMPADDRESS), resultSet.getString(EMPCITY), 
						resultSet.getLong(EMPPINCODE), resultSet.getLong(EMPMOBILENO), 
						resultSet.getString(EMPSTATE),
						resultSet.getString(EMPEMAILID), resultSet.getString(EMPPANNO), 
						department, grade, resultSet.getString(STATUS));
				employeeList.add(employ);
			}

			return employeeList;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection, resultSet);
		}
		return employeeList;

	}

	public String employStatus(int empId) {

		String query = "select status from employees where emp_id=?";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		String status = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, empId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				status = resultSet.getString(STATUS);
			}
			return status;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection, resultSet);

		}

		return status;

	}

	public Date todayDate() {

		String query = "select sysdate from dual";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		Date today = null;
		ResultSet resultSet =null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				today = resultSet.getDate(1);
			}
			return today;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection, resultSet);
		}

		return today;

	}

	public Employee findEmploy(int deptId, int grdId) {
		String findEmployeeQuery = "select  EMP_ID,EMP_NAME,EMP_DOB,EMP_DOJ,EMP_ADDRESS,EMP_CITY,"
				+ "EMP_PINCODE,EMP_MOBILE_NO,EMP_STATE,EMP_EMAIL_ID,EMP_PAN_NO,DEPT_ID,GRADE_ID,STATUS "
				+ " from employees where DEPT_ID=? and GRADE_ID=?";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		DepartmentsDaoImpl deptDao = new DepartmentsDaoImpl();
		ResultSet resultSet = null;
		Employee employee = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(findEmployeeQuery);
			preparedStatement.setInt(1, deptId);
			preparedStatement.setInt(2, grdId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Departments dept = deptDao.findDepartment(deptId);
				GradeDaoImpl gradeDao = new GradeDaoImpl();
				Grade grade = gradeDao.findGrade(grdId);
				employee = new Employee(resultSet.getInt(EMPID), resultSet.getString(EMPNAME),
						resultSet.getDate(EMPDOB), resultSet.getDate(EMPDOJ), resultSet.getString(EMPADDRESS),
						resultSet.getString(EMPCITY), resultSet.getLong(EMPPINCODE), resultSet.getLong(EMPMOBILENO),
						resultSet.getString(EMPSTATE), resultSet.getString(EMPEMAILID),
						resultSet.getString(EMPPANNO), dept, grade, resultSet.getString(STATUS));
			}

		} catch (SQLException e) {

			e.getMessage();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection, resultSet);
			
		}
		return employee;
	}
	public boolean validateEmail(Employee employ) {
		boolean flag = true;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Connection connection =null;
		try {
			ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
			connection = connectionUtilImpl.dbConnect();
			String query = "select EMP_EMAIL_ID from employees where EMP_EMAIL_ID=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, employ.getMailId());
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
	public boolean validatePanNo(Employee employ) {
		boolean flag = true;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		Connection connection =null;
		try {
			ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
			connection = connectionUtilImpl.dbConnect();
			String query = "select EMP_PAN_NO from employees where EMP_PAN_NO=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, employ.getPanNo());
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
	
	


}
