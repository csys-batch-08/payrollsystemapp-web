package com.payroll.exception;

public class LeaveException extends Exception {
	@Override
	public String getMessage() {
		return "Leave Detail not deleted";
	
	}
	public String getMessage2() {
		
		return "leave-details are not deleted";
		
	}

}
