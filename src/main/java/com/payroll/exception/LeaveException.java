package com.payroll.exception;

public class LeaveException extends Exception {
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Leave Detail not deleted";
	
	}
	public String getMessage2() {
		
		return "leave-details are not deleted";
		
	}

}
