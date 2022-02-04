package com.payroll.exception;

import java.sql.SQLIntegrityConstraintViolationException;

public class EmployeeDelException extends SQLIntegrityConstraintViolationException{
	

	private static final long serialVersionUID = 1L;
	

@Override
	public String getMessage() {
		return "Employee details can't be delete Setted as in-active";
	
	}

public String searchEmpNotFnd() {
	
	return "Data Not Found" ;
}

public String getMessage1() {
	return "Invalid Email-Id & password";

}
public String getEmployAdd() {
	return "Employee Not Added Successfully";
	
}
public String getMessage3() {
	return "That Grade Employee Already their";
	
}
public String getEmployeeEntry() {
	return "Invalid Employee Data Entry";
	
}
public String getEmployeeDel() {
	return "Employee Not Deleted Successfully";
	
}


}
