package com.payroll.model;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	
	
	private int empId;
	
	private String empName;
	
	private String status;
	
	private Date dob;
	
	private Date doj;
	
	private String address;
	
	private String city;
	
	private Long pincode;
	
	private Long mobileNo;
	
	private String state;
	
	private String mailId;
	
	private String panNo;
	
	private Departments dept;
	
	private Grade grade;
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Employee() {
		super();
	}
	public Employee(int empId, String empName, Date dob, Date doj, String address, String city, Long pincode,
			Long mobileNo, String state, String mailId, String panNo, Departments dept, Grade grade) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.dob = dob;
		this.doj = doj;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.mobileNo = mobileNo;
		this.state = state;
		this.mailId = mailId;
		this.panNo = panNo;
		this.dept = dept;
		this.grade = grade;
	}
	
	public Employee(String name, Date dob2, Date doj2, String address2, String city2, long pincode2, long mobileNumber,
			String state2, String mailId2, String panNo2, Departments depart, Grade grade2) {
		super();
		this.empName=name;
		this.dob = dob2;
		this.doj = doj2;
		this.address = address2;
		this.city = city2;
		this.pincode = pincode2;
		this.mobileNo = mobileNumber;
		this.state = state2;
		this.mailId = mailId2;
		this.panNo = panNo2;
		this.dept = depart;
		this.grade = grade2;
		
		
		
}
	public Employee( String empName, Date dob, Date doj, String address, String city, Long pincode,
			Long mobileNo, String state, String mailId, String panNo, Departments dept, Grade grade) {
		super();
		
		this.empName = empName;
		this.dob = dob;
		this.doj = doj;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
		this.mobileNo = mobileNo;
		this.state = state;
		this.mailId = mailId;
		this.panNo = panNo;
		this.dept = dept;
		this.grade = grade;
	}
	public Employee(int int1, String string, Date date,Date date2, String string2, String string3,
			long long1, long long2, String string4, String string5, String string6, Departments department,
			Grade grade2, String string7) {
		// TODO Auto-generated constructor stub
		this.empId = int1;
		this.empName = string;
		this.dob = date;
		this.doj = date2;
		this.address = string2;
		this.city = string3;
		this.pincode = long1;
		this.mobileNo = long2;
		this.state = string4;
		this.mailId = string5;
		this.panNo = string6;
		this.dept = department;
		this.grade = grade2;
		this.status=string7;
		
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, city, dept, dob, doj, empId, empName, grade, mailId, mobileNo, panNo, pincode,
				state);
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", dob=" + dob + ", doj=" + doj + ", address="
				+ address + ", city=" + city + ", pincode=" + pincode + ", mobileNo=" + mobileNo + ", state=" + state
				+ ", mailId=" + mailId + ", panNo=" + panNo + ", dept=" + dept + ", grade=" + grade + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(address, other.address) && Objects.equals(city, other.city)
				&& Objects.equals(dept, other.dept) && Objects.equals(dob, other.dob) && Objects.equals(doj, other.doj)
				&& empId == other.empId && Objects.equals(empName, other.empName) && Objects.equals(grade, other.grade)
				&& Objects.equals(mailId, other.mailId) && Objects.equals(mobileNo, other.mobileNo)
				&& Objects.equals(panNo, other.panNo) && Objects.equals(pincode, other.pincode)
				&& Objects.equals(state, other.state);
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
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
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	

	
	
}
