package com.rcpfc.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping("/WelcomePage")
	public ModelAndView helloWorld() {
	
	   logger.info("Inside TestController");
	   String message =  "Welcome to test page of Spring MVC Project";
	 
	   return new ModelAndView("welcome", "welcomeMessage", message);
	}
}
