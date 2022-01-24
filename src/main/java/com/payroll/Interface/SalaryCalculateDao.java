package com.payroll.Interface;


import java.util.Date;
import java.util.List;

import com.payroll.model.Departments;
import com.payroll.model.EmpSalary;
import com.payroll.model.Employee;
import com.payroll.model.Grade;
import com.payroll.model.Leave;

public interface SalaryCalculateDao {
	public  boolean insertSalary(Employee emp,Grade grade,Departments department,Leave leave,Date salaryDt,long grossSalary,long totalSalary);
	public void updateSalary(int transId,long basic);
	public List<EmpSalary> showEmployee();
}
