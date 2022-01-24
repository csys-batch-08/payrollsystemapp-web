package com.payroll.exception;



public class InvalidAmount extends Exception{
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Negative values are not allowed";
	
	}
	public String getMessage1() {
		
		return "That Department Grade Already exist";
	}
	
}
