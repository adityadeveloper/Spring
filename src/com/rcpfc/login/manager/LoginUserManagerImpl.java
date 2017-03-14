package com.rcpfc.login.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rcpfc.login.dao.LoginUserDAO;
import com.rcpfc.login.model.LoginUserVO;

@Service
@Transactional
public class LoginUserManagerImpl implements LoginUserManager {
	@Autowired
	LoginUserDAO loginuserdao;
	
	@Override
	public void addUser(LoginUserVO loginuser) {
		loginuserdao.save(loginuser);
	}

	@Override
	public void deleteUser(LoginUserVO loginuser) {
		loginuserdao.delete(loginuser);
	}

	@Override
	public List<LoginUserVO> getUserList(String username) {
		return loginuserdao.getByUsername(username);
	}

	@Override
	public LoginUserVO getUserByMobileNumber(String mobileNumber) {
		return loginuserdao.getByMobileNumber(mobileNumber);
	}
}
