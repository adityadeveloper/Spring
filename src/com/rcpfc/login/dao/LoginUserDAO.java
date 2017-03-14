package com.rcpfc.login.dao;

import java.util.List;

import com.rcpfc.base.BaseDAO;
import com.rcpfc.login.model.LoginUserVO;

public interface LoginUserDAO extends BaseDAO<LoginUserVO> {
	
	public void save(LoginUserVO loginuser);
	public void delete(LoginUserVO loginuser);
	public List<LoginUserVO> getByUsername(String username);
	public LoginUserVO getByMobileNumber (String mobileNumber);
}
