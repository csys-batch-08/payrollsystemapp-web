package com.payroll.model;

import java.util.Objects;

public class Departments {
	private int deptId;
	private String deptName;
	private String status;

	
	public Departments(int deptId, String deptName, String status) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Departments() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Departments(int deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		
	}
	
	public Departments(String deptName) {
		// TODO Auto-generated constructor stub
		super();
		this.deptName = deptName;
		
	}
	@Override
	public String toString() {
		return "deptId = " + deptId + "\n deptName = " + deptName + "\n";
	}
	@Override
	public int hashCode() {
		return Objects.hash(deptId, deptName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departments other = (Departments) obj;
		return deptId == other.deptId && Objects.equals(deptName, other.deptName) ;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
	

}
