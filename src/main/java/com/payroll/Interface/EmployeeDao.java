package com.payroll.Interface;

import java.util.List;

import com.payroll.model.Employee;

public interface EmployeeDao {
	public  boolean insertEmp(Employee emp);
	public  Employee findEmployee(int empId);
	public int updateEmp(Employee employ);
	public int deleteEmp(int  empId);
	public int findEmployeeID(Employee emp);
	public List<Employee> showEmployee();
	public Employee findEmploy(String email);

}
