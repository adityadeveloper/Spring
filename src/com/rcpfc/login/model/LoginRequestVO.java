package com.rcpfc.login.model;

import java.io.Serializable;
import com.github.reinert.jjschema.Attributes;

public class LoginRequestVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Attributes(required = true)
	private String password;
	
	@Attributes(required = true)
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
