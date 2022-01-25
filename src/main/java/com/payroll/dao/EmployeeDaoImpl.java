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
		ConnectionUtilImpl connection = new ConnectionUtilImpl();
		Connection con = connection.dbConnect();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(insertQuery);

			pstmt.setString(1, emp.getEmpName());
			pstmt.setDate(2, new java.sql.Date(emp.getDob().getTime()));
			pstmt.setDate(3, new java.sql.Date(emp.getDoj().getTime()));
			pstmt.setString(4, emp.getAddress());
			pstmt.setString(5, emp.getCity());
			pstmt.setLong(6, emp.getPincode());
			pstmt.setLong(7, emp.getMobileNo());
			pstmt.setString(8, emp.getState());
			pstmt.setString(9, emp.getMailId());
			pstmt.setString(10, emp.getPanNo());
			pstmt.setInt(11, emp.getDept().getDeptId());
			pstmt.setInt(12, emp.getGrade().getGradeId());
			result = pstmt.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectionUtilImpl.closePreparedStatement(pstmt, con);
		}
		return result;

	}

	public Employee findEmployee(int empId) {
		String findEmployeeQuery = "select EMP_ID,EMP_NAME,EMP_DOB,EMP_DOJ,EMP_ADDRESS,EMP_CITY,EMP_PINCODE,EMP_MOBILE_NO,EMP_STATE,EMP_EMAIL_ID,EMP_PAN_NO,DEPT_ID,GRADE_ID,STATUS from employees where emp_id=?";
		ConnectionUtilImpl connection = new ConnectionUtilImpl();
		Connection con = connection.dbConnect();
		Employee employee = null;
		DepartmentsDaoImpl deptDao = new DepartmentsDaoImpl();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(findEmployeeQuery);
			pstmt.setInt(1, empId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				GradeDaoImpl gradeDao = new GradeDaoImpl();
				Grade grade = gradeDao.findGrade(rs.getInt(13));
				Departments dept = deptDao.findDepartment(rs.getInt(12));
				employee = new Employee(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getString(5),
						rs.getString(6), rs.getLong(7), rs.getLong(8), rs.getString(9), rs.getString(10),
						rs.getString(11), dept, grade);
			}
			return employee;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(pstmt, con);
		}
		return employee;
	}

	public int updateEmp(Employee employ) {

		String insertQuery = " update employees set EMP_NAME=?,EMP_DOB=?,EMP_DOJ=?,EMP_ADDRESS=?,EMP_CITY=?,EMP_PINCODE=?,EMP_MOBILE_NO=?,EMP_STATE=?,EMP_EMAIL_ID=?,EMP_PAN_NO=? ,DEPT_ID=?,GRADE_ID=?where emp_id= ?";
		ConnectionUtilImpl connection = new ConnectionUtilImpl();
		Connection con = connection.dbConnect();
		int i = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(insertQuery);
			pstmt.setString(1, employ.getEmpName());
			pstmt.setDate(2, new java.sql.Date(employ.getDob().getTime()));
			pstmt.setDate(3, new java.sql.Date(employ.getDoj().getTime()));
			pstmt.setString(4, employ.getAddress());
			pstmt.setString(5, employ.getCity());
			pstmt.setLong(6, employ.getPincode());
			pstmt.setLong(7, employ.getMobileNo());
			pstmt.setString(8, employ.getState());
			pstmt.setString(9, employ.getMailId());
			pstmt.setString(10, employ.getPanNo());
			pstmt.setInt(11, employ.getDept().getDeptId());
			pstmt.setInt(12, employ.getGrade().getGradeId());
			pstmt.setInt(13, employ.getEmpId());

			i = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(pstmt, con);
		}
		return i;

	}

	public int deleteEmp(int empId) {
		String deleteQuery = "delete from employees where EMP_ID=?";

		ConnectionUtilImpl connection = new ConnectionUtilImpl();
		Connection con = connection.dbConnect();
		int i = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(deleteQuery);
			pstmt.setInt(1, empId);
			i = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(pstmt, con);
		}
		return i;

	}

	public int findEmployeeID(Employee emp) {
		String findId = "select emp_id from employees where emp_email_id= '" + emp.getMailId() + "'";
		ConnectionUtilImpl connection = new ConnectionUtilImpl();
		Connection con = connection.dbConnect();
		Statement stmt = null;
		int id = 0;
		try {
			stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(findId);
			if (rs.next()) {
				id = rs.getInt(1);
				return id;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closeStatement(stmt, con);
		}

		return id;
	}

	public List<Employee> showEmployee() {
		List<Employee> employeeList = new ArrayList<Employee>();

		String showQuery = "select  EMP_ID,EMP_NAME,EMP_DOB,EMP_DOJ,EMP_ADDRESS,EMP_CITY,EMP_PINCODE,EMP_MOBILE_NO,EMP_STATE,EMP_EMAIL_ID,EMP_PAN_NO,DEPT_ID,GRADE_ID,STATUS  from employees where status = 'active' ";
		ConnectionUtilImpl connection = new ConnectionUtilImpl();
		Connection con = connection.dbConnect();
		DepartmentsDaoImpl deptDao = new DepartmentsDaoImpl();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(showQuery);
			while (rs.next()) {
				GradeDaoImpl gradeDao = new GradeDaoImpl();
				Grade grade = gradeDao.findGrade(rs.getInt(13));
				Departments depart = deptDao.findDepartment(rs.getInt(12));
				Employee employee = new Employee(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4),
						rs.getString(5), rs.getString(6), rs.getLong(7), rs.getLong(8), rs.getString(9),
						rs.getString(10), rs.getString(11), depart, grade);
				employeeList.add(employee);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closeStatement(stmt, con);
		}

		return employeeList;
	}

	public List<Employee> showInactiveEmployee() {
		List<Employee> employeeList = new ArrayList<Employee>();

		String showQuery = "select  EMP_ID,EMP_NAME,EMP_DOB,EMP_DOJ,EMP_ADDRESS,EMP_CITY,EMP_PINCODE,EMP_MOBILE_NO,EMP_STATE,EMP_EMAIL_ID,EMP_PAN_NO,DEPT_ID,GRADE_ID,STATUS  from employees where status= 'inactive' ";
		ConnectionUtilImpl connection = new ConnectionUtilImpl();
		Connection con = connection.dbConnect();
		DepartmentsDaoImpl deptDao = new DepartmentsDaoImpl();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(showQuery);
			while (rs.next()) {
				GradeDaoImpl gradeDao = new GradeDaoImpl();
				Grade grade = gradeDao.findGrade(rs.getInt(13));
				Departments depart = deptDao.findDepartment(rs.getInt(12));
				Employee employee = new Employee(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4),
						rs.getString(5), rs.getString(6), rs.getLong(7), rs.getLong(8), rs.getString(9),
						rs.getString(10), rs.getString(11), depart, grade);
				employeeList.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closeStatement(stmt, con);
		}
		return employeeList;
	}

	public Employee findEmploy(String email) {
		String findEmployeeQuery = "select  EMP_ID,EMP_NAME,EMP_DOB,EMP_DOJ,EMP_ADDRESS,EMP_CITY,EMP_PINCODE,EMP_MOBILE_NO,EMP_STATE,EMP_EMAIL_ID,EMP_PAN_NO,DEPT_ID,GRADE_ID,STATUS  from employees where EMP_EMAIL_ID=?";
		ConnectionUtilImpl connection = new ConnectionUtilImpl();
		Connection con = connection.dbConnect();
		DepartmentsDaoImpl deptDao = new DepartmentsDaoImpl();

		Employee employee = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(findEmployeeQuery);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				GradeDaoImpl gradeDao = new GradeDaoImpl();
				Grade grade = gradeDao.findGrade(rs.getInt(13));
				Departments dept = deptDao.findDepartment(rs.getInt(12));
				employee = new Employee(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getString(5),
						rs.getString(6), rs.getLong(7), rs.getLong(8), rs.getString(9), rs.getString(10),
						rs.getString(11), dept, grade);
			}

		} catch (SQLException e) {

			e.getMessage();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(pstmt, con);
		}
		return employee;
	}

	public void deleteEmp(String email) {
		String deleteQuery = "delete from employees where EMP_EMAIL_ID='" + email + "'";
		ConnectionUtilImpl connection = new ConnectionUtilImpl();
		Connection con = connection.dbConnect();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(deleteQuery);

		} catch (Exception e) {
			// catch the exception and get that message
			e.getMessage();
		} finally {
			ConnectionUtilImpl.closeStatement(stmt, con);
		}
	}

	public int updateEmpStatus(Employee employ) {

		String insertQuery = " update employees set STATUS='inactive' where emp_id= ?";
		ConnectionUtilImpl connection = new ConnectionUtilImpl();
		Connection con = connection.dbConnect();
		PreparedStatement pstmt = null;
		int i = 0;
		try {
			pstmt = con.prepareStatement(insertQuery);
			pstmt.setInt(1, employ.getEmpId());
			i = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(pstmt, con);
		}
		return i;

	}

	public int updateStatusActive(Employee employ) {

		String insertQuery = " update employees set STATUS='active' where emp_id= ?";
		ConnectionUtilImpl connection = new ConnectionUtilImpl();
		Connection con = connection.dbConnect();
		int i = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(insertQuery);
			pstmt.setInt(1, employ.getEmpId());
			i = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(pstmt, con);
		}
		return i;

	}

	public List<Employee> searchEmployee(String empName) {
		ConnectionUtilImpl connection = new ConnectionUtilImpl();
		Connection con = connection.dbConnect();
		String query = "select  EMP_ID,EMP_NAME,EMP_DOB,EMP_DOJ,EMP_ADDRESS,EMP_CITY,EMP_PINCODE,EMP_MOBILE_NO,EMP_STATE,EMP_EMAIL_ID,EMP_PAN_NO,DEPT_ID,GRADE_ID,STATUS  from employees where upper(EMP_NAME) like ?";
		ResultSet rs = null;
		List<Employee> employeeList = new ArrayList<Employee>();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, empName.toUpperCase() );
			rs = pstmt.executeQuery();
			while (rs.next()) {
				GradeDaoImpl gradeDao = new GradeDaoImpl();
				Grade grade = gradeDao.findGrade(rs.getInt(13));
				DepartmentsDaoImpl departDao = new DepartmentsDaoImpl();
				Departments department = departDao.findDepartment(rs.getInt(12));
				Employee employ = new Employee(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4),
						rs.getString(5), rs.getString(6), rs.getLong(7), rs.getLong(8), rs.getString(9),
						rs.getString(10), rs.getString(11), department, grade, rs.getString(14));
				employeeList.add(employ);
			}

			return employeeList;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(pstmt, con);
		}
		return employeeList;

	}

	public String employStatus(int empId) {

		String query = "select status from employees where emp_id=?";
		ConnectionUtilImpl connection = new ConnectionUtilImpl();
		Connection con = connection.dbConnect();
		String status = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, empId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				status = rs.getString(1);
			}
			return status;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(pstmt, con);

		}

		return status;

	}

	public Date todayDate() {

		String query = "select sysdate from dual";
		ConnectionUtilImpl connection = new ConnectionUtilImpl();
		Connection con = connection.dbConnect();
		Date today = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				today = rs.getDate(1);
			}
			return today;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(pstmt, con);
		}

		return today;

	}

	public Employee findEmploy(int deptId, int grdId) {
		String findEmployeeQuery = "select  EMP_ID,EMP_NAME,EMP_DOB,EMP_DOJ,EMP_ADDRESS,EMP_CITY,EMP_PINCODE,EMP_MOBILE_NO,EMP_STATE,EMP_EMAIL_ID,EMP_PAN_NO,DEPT_ID,GRADE_ID,STATUS  from employees where DEPT_ID=? and GRADE_ID=?";
		ConnectionUtilImpl connection = new ConnectionUtilImpl();
		Connection con = connection.dbConnect();
		DepartmentsDaoImpl deptDao = new DepartmentsDaoImpl();

		Employee employee = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(findEmployeeQuery);
			pstmt.setInt(1, deptId);
			pstmt.setInt(2, grdId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Departments dept = deptDao.findDepartment(rs.getInt(12));
				GradeDaoImpl gradeDao = new GradeDaoImpl();
				Grade grade = gradeDao.findGrade(grdId);
				employee = new Employee(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getString(5),
						rs.getString(6), rs.getLong(7), rs.getLong(8), rs.getString(9), rs.getString(10),
						rs.getString(11), dept, grade, rs.getString(14));
			}

		} catch (SQLException e) {

			e.getMessage();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(pstmt, con);
		}
		return employee;
	}

}
