package com.rcpfc.login.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.rcpfc.base.BaseController;

import com.rcpfc.login.model.LoginRequestVO;
import com.rcpfc.login.model.LoginResponseVO;
import com.rcpfc.login.model.LoginUserVO;
import com.rcpfc.utility.UtilityFunctions;

import org.apache.commons.io.IOUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

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
	public @ResponseBody LoginResponseVO getEmployee(HttpServletRequest request) {
		LoginUserVO userVO = null;
		LoginRequestVO requestVO = null;
		LoginResponseVO responseVO = new LoginResponseVO();
		
		try{
			String inputRequest = IOUtils.toString(request.getInputStream());
			
			ObjectMapper objectMapper = new ObjectMapper();
			requestVO = objectMapper.readValue(inputRequest, LoginRequestVO.class);
			
			String mobileNumber = requestVO.getMobileNumber();
			String password = requestVO.getPassword();
			
			logger.info("Mobile Number : "+mobileNumber);
			logger.info("Password : "+password);
			
			logger.info("Login request received for username : "+mobileNumber);
			
			userVO = loginusermanager.getUserByMobileNumber(mobileNumber);
				
				if(userVO != null){
					if(userVO.getPassword().equals(password)){
						responseVO.setStatus("SUCCESS");
						responseVO.setCode("200");
						responseVO.setUsername(userVO.getUsername());
						responseVO.setMobileNumber(userVO.getMobileNumber());
						
						logger.info("Login request completed. Result : SUCCESS");
					}
					
					else{
						responseVO.setStatus("WRONG_PASSWORD");
						responseVO.setCode("201");
						logger.info("Login request completed. Result : WRONG_PASSWORD");
					}
	
				}
				
				else{
					responseVO.setStatus("INVALID_USER");
					responseVO.setCode("202");
					
					logger.info("Login request completed. Result : INVALID_USER");
				}
				
			return responseVO;
		}
		
		catch(UnrecognizedPropertyException upex){
			logger.error("Exception occured while parsing the JSON request");
			responseVO.setCode("500");
			responseVO.setStatus("Passed JSON request in invalid");
			return responseVO;
		}
		
		catch(Exception e){
			logger.error("Exception occured", e);
			return null;
		}
	}

}
