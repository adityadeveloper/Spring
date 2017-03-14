package com.rcpfc.login.model;

import java.io.Serializable;

public class LoginRequestVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String password;
	private String mobileNumber;
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
