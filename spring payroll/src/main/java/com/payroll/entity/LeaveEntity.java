package com.payroll.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.payroll.model.Employee;

@Entity
@Table(name="leave_details")
public class LeaveEntity {
	
	@Id
	@Column(name = "LEAVE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int leaveId;
	
	@Column(name = "EMP_ID")
	private Employee employ;
	
	@Column(name="LEAVE_DATE")
	private Date leaveDt;
	
	@Column(name="REASON")
	private String leaveReason;

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	public Employee getEmploy() {
		return employ;
	}

	public void setEmploy(Employee employ) {
		this.employ = employ;
	}

	public Date getLeaveDt() {
		return leaveDt;
	}

	public void setLeaveDt(Date leaveDt) {
		this.leaveDt = leaveDt;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	@Override
	public String toString() {
		return "LeaveEntity [leaveId=" + leaveId + ", employ=" + employ + ", leaveDt=" + leaveDt + ", leaveReason="
				+ leaveReason + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(employ, leaveDt, leaveId, leaveReason);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LeaveEntity other = (LeaveEntity) obj;
		return Objects.equals(employ, other.employ) && Objects.equals(leaveDt, other.leaveDt)
				&& leaveId == other.leaveId && Objects.equals(leaveReason, other.leaveReason);
	}

	public LeaveEntity(int leaveId, Employee employ, Date leaveDt, String leaveReason) {
		super();
		this.leaveId = leaveId;
		this.employ = employ;
		this.leaveDt = leaveDt;
		this.leaveReason = leaveReason;
	}

	public LeaveEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
