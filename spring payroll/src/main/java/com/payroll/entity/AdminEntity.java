package com.payroll.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_details")
public class AdminEntity {

	@Id
	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "PASSWORD")
	private String password;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(password, emailId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminEntity other = (AdminEntity) obj;
		return Objects.equals(password, other.password) && Objects.equals(emailId, other.emailId);
	}

	@Override
	public String toString() {

		return "emailId=" + emailId + "\n password=" + password;
	}

	public AdminEntity(String emailId, String password) {
			super();
			this.emailId = emailId;
			this.password = password;
		}

	public AdminEntity() {
			super();
		}

}
