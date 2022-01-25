package com.payroll.model;

import java.util.Date;
import java.util.Objects;

public class EmpSalary {
	private Employee emp;
	private Departments dept;
	private int transId;
	public EmpSalary(Employee emp, Departments dept, int transId, int totalLeave, Grade grade, Long gross, Long salary,
			Date salaryDate) {
		super();
		this.emp = emp;
		this.dept = dept;
		this.transId = transId;
		this.totalLeave = totalLeave;
		this.grade = grade;
		this.gross = gross;
		this.salary = salary;
		this.salaryDate = salaryDate;
	}
	public int getTransId() {
		return transId;
	}
	public void setTransId(int transId) {
		this.transId = transId;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	private int totalLeave;
	private Grade grade;
	private Long gross;
	private Long salary;
	private Date salaryDate;
	public Date getSalaryDate() {
		return salaryDate;
	}
	public void setSalaryDate(Date salaryDate) {
		this.salaryDate = salaryDate;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmpId(Employee empId) {
		this.emp = emp;
	}
	public Departments getDept() {
		return dept;
	}
	public void setDept(Departments dept) {
		this.dept = dept;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGradeId(Grade grade) {
		this.grade = grade;
	}
	

	public Long getGross() {
		return gross;
	}
	public void setGross(Long gross) {
		this.gross = gross;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dept, emp, grade, gross, salary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpSalary other = (EmpSalary) obj;
		return Objects.equals(dept, other.dept) && Objects.equals(emp, other.emp)
				&& Objects.equals(grade, other.grade) && Objects.equals(gross, other.gross)
				&& Objects.equals(salary, other.salary) ;
	}
	@Override
	public String toString() {
		return "emp=" + emp + "\n dept=" + dept + "\n grade=" + grade + "\n "
				+ "\n gross=" + gross + "\n salary=" + salary + "\n";
	}
	

	public EmpSalary(Employee empId, Departments deptId, int totalLeave, Grade gradeId, Long gross, Long salary,
			Date salaryDate) {
		super();
		this.emp= empId;
		this.dept = deptId;
		this.totalLeave = totalLeave;
		this.grade = gradeId;
		this.gross = gross;
		this.salary = salary;
		this.salaryDate = salaryDate;
	}
	public int getTotalLeave() {
		return totalLeave;
	}
	public void setTotalLeave(int totalLeave) {
		this.totalLeave = totalLeave;
	}
	public EmpSalary() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpSalary(Employee emp, Departments department, int leave, Grade grade,Date date, long gross,
			long total) {
		super();
		this.emp= emp;
		this.dept = department;
		this.totalLeave = leave;
		this.grade = grade;
		this.gross = gross;
		this.salary = total;
		this.salaryDate = date;
	}
	
	
	

	
}
