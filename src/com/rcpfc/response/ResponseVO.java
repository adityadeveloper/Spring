package com.rcpfc.response;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rcpfc.login.model.LoginResponseVO;

@XmlRootElement(name = "result")
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

	@XmlElement
	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}
	
	@XmlElement
	public void setCode(String code) {
		this.code = code;
	}

	@XmlElement(name = "LoginResponse")
	public LoginResponseVO getLoginResponseVO() {
		return loginResponseVO;
	}

	public void setLoginResponseVO(LoginResponseVO loginResponseVO) {
		this.loginResponseVO = loginResponseVO;
	}
	
	
}
