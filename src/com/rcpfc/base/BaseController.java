package com.rcpfc.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.rcpfc.login.manager.LoginUserManager;

public class BaseController {
	
	@Autowired
	protected LoginUserManager loginusermanager;
}
