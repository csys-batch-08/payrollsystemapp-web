package com.payroll.exception;

public class DepartmentException extends Exception{
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Department not inserted properly";
		
	}
	public String getDeptInvalid() {
		return "Department Grade already exist";
		
	}
	public String deptNotUpdate() {
		return "Department Not Updated Successfully";
		
	}
	public String deptDelete() {
		return "Department not deleted Successfully";
		
	}
	public String gradeDept() {
		return "That Department Grade Not Exist";
		
	}
	public String searchdepartfound() {
		return "No Data Found";
		
		
	}
}
