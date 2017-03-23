package com.rcpfc.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rcpfc.login.model.LoginResponseVO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String status;
	private String code;
	
	@JsonProperty(value="LoginResponse")
	private LoginResponseVO loginResponseVO;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LoginResponseVO getLoginResponseVO() {
		return loginResponseVO;
	}

	public void setLoginResponseVO(LoginResponseVO loginResponseVO) {
		this.loginResponseVO = loginResponseVO;
	}
	
	
}
