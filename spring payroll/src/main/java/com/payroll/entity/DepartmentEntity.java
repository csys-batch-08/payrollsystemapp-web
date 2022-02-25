package com.payroll.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="departments")
public class DepartmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="DEPT_ID")
	private int deptId;
	
	@Column(name="DEPT_NAME")
	private String deptName;
	
	@Column(name="STATUS")
	private String status;
	public DepartmentEntity(int deptId, String deptName, String status) {
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
	public DepartmentEntity() {
		super();
	}
	public DepartmentEntity(int deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		
	}
	
	public DepartmentEntity(String deptName) {
		super();
		this.deptName = deptName;
		
	}
	@Override
	public String toString() {
		return "deptId = " + deptId + "\n deptName = " + deptName + "\n";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(deptId, deptName, status);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepartmentEntity other = (DepartmentEntity) obj;
		return deptId == other.deptId && Objects.equals(deptName, other.deptName)
				&& Objects.equals(status, other.status);
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
