package com.payroll.model;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class Admin implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String emailId;

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
		Admin other = (Admin) obj;
		return Objects.equals(password, other.password) && Objects.equals(emailId, other.emailId);
	}

	@Override
	public String toString() {

		return "emailId=" + emailId + "\n password=" + password;
	}

	public Admin(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}

	public Admin() {
		super();
	}

}
