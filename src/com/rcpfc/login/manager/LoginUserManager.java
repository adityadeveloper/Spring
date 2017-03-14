package com.rcpfc.login.manager;

import java.util.List;

import com.rcpfc.login.model.LoginUserVO;

public interface LoginUserManager {
	
	public void addUser(LoginUserVO loginuser);
	public void deleteUser(LoginUserVO loginuser);
	public List<LoginUserVO> getUserList(String username);
	public LoginUserVO getUserByMobileNumber(String mobileNumber);
	
}
