package com.payroll.dao;



import java.util.List;

import com.payroll.model.Departments;

public interface DepartmentDao {
	public int insertDep(Departments dprt) ;
	public  int findDepartmentID(Departments dept);
	public int updateDept(Departments depart);
	public boolean deleteDept(int  deptId);
	public List<Departments> showDepartments();
	public Departments	findDepartment(int id);
	public Departments	findDepartment(String deptName);


}
