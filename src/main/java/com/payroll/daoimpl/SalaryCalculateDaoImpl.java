package com.payroll.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.payroll.model.Departments;
import com.payroll.model.EmpSalary;
import com.payroll.model.Employee;
import com.payroll.model.Grade;

public class SalaryCalculateDaoImpl 
{
	static final String TRANSID="TRANS_ID";
	static final String EMPID="EMP_ID";
	static final String DEPTID="DEPT_ID";
	static final String TOTALLEAVE="TOTAL_LEAVE";
	static final String GRADEID="GRADE_ID";
	static final String PAIDDATE="PAID_DATE";
	static final String GROSSSALARY="GROSS_SALARY";
	static final String TOTALSALARY="TOTAL_SALARY";
	static final String NEXTPAYDATE="NEXTPAY_DATE";
	static final String EMPSALARY="emp_Salary";
	static final String ACTIVE="active_emp";
	static final String INACTIVE="inactive_emp";
	static final String TOTAL="total";

	public boolean insertSalary(Employee employ, Grade grade, Departments department, int noOfLeave, long grossSalary,
			long totalSalary) {
		boolean result = false;
		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		DepartmentsDaoImpl departmentDao = new DepartmentsDaoImpl();
		int empID = employeeDaoImpl.findEmployeeID(employ);
		int deptID = departmentDao.findDepartmentID(department);
		GradeDaoImpl gradeDaoImpl = new GradeDaoImpl();
		int gradeID = gradeDaoImpl.findGradeID(grade);

		String query = "insert into salarys (EMP_ID,DEPT_ID,TOTAL_LEAVE,GRADE_ID,GROSS_SALARY,TOTAL_SALARY,nextpay_date) values(?,?,?,?,?,?,sysdate+30)";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, empID);
			preparedStatement.setInt(2, deptID);
			preparedStatement.setInt(3, noOfLeave);
			preparedStatement.setInt(4, gradeID);
			preparedStatement.setLong(5, grossSalary);
			preparedStatement.setLong(6, totalSalary);
			preparedStatement.executeUpdate();
			result = true;
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		return result;

	}

	public List<EmpSalary> showEmployee() {
		List<EmpSalary> salaryList = new ArrayList<EmpSalary>();

		String showQuery = "select TRANS_ID,EMP_ID,DEPT_ID,TOTAL_LEAVE,GRADE_ID,PAID_DATE,GROSS_SALARY,TOTAL_SALARY,NEXTPAY_DATE from salarys ";
		ConnectionUtilImpl connection = new ConnectionUtilImpl();
		Connection con = connection.dbConnect();
		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		Statement statement = null;
		try {
			statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(showQuery);
			while (resultSet.next()) {

				Employee employ = employeeDaoImpl.findEmployee(resultSet.getInt(EMPID));
				DepartmentsDaoImpl departmentDao = new DepartmentsDaoImpl();
				GradeDaoImpl gradeDaoImpl = new GradeDaoImpl();

				Departments department = departmentDao.findDepartment(resultSet.getInt(DEPTID));
				Grade grade = gradeDaoImpl.findGrade(resultSet.getInt(GRADEID));

				EmpSalary empSalary = new EmpSalary(employ, department, resultSet.getInt(TRANSID), resultSet.getInt(TOTALLEAVE), grade,
						resultSet.getLong(GROSSSALARY), resultSet.getLong(TOTALSALARY), resultSet.getDate(PAIDDATE));
				salaryList.add(empSalary);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closeStatement(statement, con);
		}

		return salaryList;
	}

	public EmpSalary salaryDetail(int empId) {
		String query = "select TRANS_ID,EMP_ID,DEPT_ID,TOTAL_LEAVE,GRADE_ID,PAID_DATE,GROSS_SALARY,TOTAL_SALARY,NEXTPAY_DATE  from salarys where EMP_ID=?";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		EmpSalary salary = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, empId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				EmployeeDaoImpl empDao = new EmployeeDaoImpl();

				Employee emp = empDao.findEmployee(resultSet.getInt(EMPID));
				GradeDaoImpl gradeDao = new GradeDaoImpl();
				Grade grade = gradeDao.findGrade(resultSet.getInt(GRADEID));
				DepartmentsDaoImpl departDao = new DepartmentsDaoImpl();
				Departments department = departDao.findDepartment(resultSet.getInt(DEPTID));

				salary = new EmpSalary(emp, department, resultSet.getInt(TOTALLEAVE), grade,
						new java.sql.Date(resultSet.getDate(PAIDDATE).getTime()), resultSet.getLong(GROSSSALARY), resultSet.getLong(TOTALSALARY));
				return salary;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}

		return salary;

	}

	public Date salaryDate(int empId) {
		String query = "select paid_date from salarys where EMP_ID=?";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		Date paidDt = null;
		PreparedStatement preparedStatement = null;
		try {

			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, empId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				paidDt = resultSet.getDate(PAIDDATE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}

		return paidDt;

	}

	public Date salaryNxtMonth(int empId) {
		String query = "select NEXTPAY_DATE from salarys where EMP_ID=?";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		Date paidDt = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, empId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				paidDt = resultSet.getDate(NEXTPAYDATE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		return paidDt;

	}

	public int salaryEmpCount() {
		String query = "select count(emp_id) emp_Salary from salarys";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		int count = 0;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				count = resultSet.getInt(EMPSALARY);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}

		return count;

	}

	public int activeEmployee() {
		String query = "select count(*) as active_emp from employees where status='active'";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		int activeCount = 0;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				activeCount = resultSet.getInt(ACTIVE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);

		}
		return activeCount;

	}

	public int inActiveEmployee() {
		String query = "select count(*) as inactive_emp from employees where status='inactive'";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		int inActiveCount = 0;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				inActiveCount = resultSet.getInt(INACTIVE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		return inActiveCount;

	}

	public int totalSal(Date salFrom, Date salTo) {
		String query = "select sum(TOTAL_SALARY) as total from salarys where PAID_DATE  between ? and ?";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		int total = 0;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDate(1, new java.sql.Date(salFrom.getTime()));
			preparedStatement.setDate(2, new java.sql.Date(salTo.getTime()));
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				total = resultSet.getInt(TOTAL);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}

		return total;
	}

	public int deleteSalary(int transId) {
		String query = "delete from salarys where TRANS_ID =?";
		ConnectionUtilImpl connectionUtilImpl = new ConnectionUtilImpl();
		Connection connection = connectionUtilImpl.dbConnect();
		PreparedStatement preparedStatement = null;
		int i = 0;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, transId);
			i = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtilImpl.closePreparedStatement(preparedStatement, connection);
		}
		return i;

	}

}



