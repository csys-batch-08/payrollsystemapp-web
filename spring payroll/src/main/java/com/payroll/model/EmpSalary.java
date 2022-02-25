package com.payroll.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="salarys")
public class EmpSalary {
	
	@Column(name="EMP_ID")
	private Employee emp;
	
	@Column(name="DEPT_ID")
	private Departments dept;
	
	
	@Id
	@Column(name = "TRANS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transId;
	
	@Column(name="TOTAL_LEAVE")
	private int totalLeave;
	
	@Column(name="GRADE_ID")
	private Grade grade;
	
	@Column(name="GROSS_SALARY")
	private Long gross;
	
	@Column(name="TOTAL_SALARY")
	private Long salary;
	
	@Column(name="PAID_DATE")
	private Date salaryDate;
	
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
	
	public Date getSalaryDate() {
		return salaryDate;
	}
	public void setSalaryDate(Date salaryDate) {
		this.salaryDate = salaryDate;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmpId(Employee emp) {
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
