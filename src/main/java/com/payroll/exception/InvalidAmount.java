package com.payroll.exception;



public class InvalidAmount extends Exception{
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Negative values are not allowed";
	
	}
	public String getMessage1() {
		
		return "That Department Grade Already exist";
	}
	
}
