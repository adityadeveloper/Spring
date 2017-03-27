package com.rcpfc.utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping("/WelcomePage")
	public ModelAndView helloWorld() {
	
	   logger.info("Inside TestController");
	   String message =  "Welcome to RCPFC !!!";
	 
	   return new ModelAndView("welcome", "welcomeMessage", message);
	}
	
	@RequestMapping(value="index")
    public String index() {
        return "index";
    }
    @RequestMapping(value="viewPeson")
    public ModelAndView viewPersons(Model model) {
        Map<String, List<Person>> persons =
                new HashMap<String, List<Person>>();
        persons.put("persons", Person.createPersons());
        return new ModelAndView("personList", persons);
    }
}
