package com.rcpfc.login.controller;

import com.rcpfc.base.BaseController;

import com.rcpfc.login.model.LoginRequestVO;
import com.rcpfc.login.model.LoginResponseVO;
import com.rcpfc.login.model.LoginUserVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginUserController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginUserController.class);
	
	@RequestMapping(value = "/rest/login", method = RequestMethod.POST)
	public @ResponseBody LoginResponseVO getEmployee(@RequestBody LoginRequestVO loginRequest) {
		List<LoginUserVO> userList = null;
		LoginUserVO userVO = null;
		LoginResponseVO responseVO = new LoginResponseVO();
		String mobileNumber = loginRequest.getMobileNumber();
		
		logger.info("Login request received for username : "+mobileNumber);
		
		userVO = loginusermanager.getUserByMobileNumber(mobileNumber);
			
			if(userVO != null){
				responseVO.setStatus("Success");
				responseVO.setCode(200);
				responseVO.setUsername(userVO.getUsername());
				responseVO.setMobileNumber(userVO.getMobileNumber());
				
				logger.info("Login request completed. Result : Success");
			}
			
			else{
				responseVO.setStatus("User doesn't exist");
				responseVO.setCode(201);
				
				logger.info("Login request completed. Result : User dosen't exist");
			}
			
		return responseVO;
	}

	
}
