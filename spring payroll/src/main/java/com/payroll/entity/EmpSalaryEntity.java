package com.payroll.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.payroll.model.Departments;
import com.payroll.model.Employee;
import com.payroll.model.Grade;

@Entity
@Table(name="salarys")
public class EmpSalaryEntity {

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

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public Departments getDept() {
		return dept;
	}

	public void setDept(Departments dept) {
		this.dept = dept;
	}

	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public int getTotalLeave() {
		return totalLeave;
	}

	public void setTotalLeave(int totalLeave) {
		this.totalLeave = totalLeave;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
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

	public Date getSalaryDate() {
		return salaryDate;
	}

	public void setSalaryDate(Date salaryDate) {
		this.salaryDate = salaryDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dept, emp, grade, gross, salary, salaryDate, totalLeave, transId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpSalaryEntity other = (EmpSalaryEntity) obj;
		return Objects.equals(dept, other.dept) && Objects.equals(emp, other.emp) && Objects.equals(grade, other.grade)
				&& Objects.equals(gross, other.gross) && Objects.equals(salary, other.salary)
				&& Objects.equals(salaryDate, other.salaryDate) && totalLeave == other.totalLeave
				&& transId == other.transId;
	}

	public EmpSalaryEntity(Employee emp, Departments dept, int transId, int totalLeave, Grade grade, Long gross,
			Long salary, Date salaryDate) {
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

	public EmpSalaryEntity() {
		super();
	}

	@Override
	public String toString() {
		return "EmpSalaryEntity [emp=" + emp + ", dept=" + dept + ", transId=" + transId + ", totalLeave=" + totalLeave
				+ ", grade=" + grade + ", gross=" + gross + ", salary=" + salary + ", salaryDate=" + salaryDate + "]";
	}
	
}
