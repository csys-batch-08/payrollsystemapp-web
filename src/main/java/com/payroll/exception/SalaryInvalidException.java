package com.payroll.exception;

public class SalaryInvalidException extends Exception {
	@Override
 public String getMessage() {
	return "Salary not approved";
	 
 }
	public String getSalMessage() {
		return "Employee Salary Approve after 30 days";
		
	}
	public String statusInactiveEmp() {
		return "Salary Didn't Approve Inactive Employee";
		
	}
	public String employInvalid() 
	{
		return "Employeee Not Found";
		
	}
}
