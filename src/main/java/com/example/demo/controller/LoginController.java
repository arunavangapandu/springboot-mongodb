package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {

	// Session store param values across multiple requests.
	
	@Autowired // Injected automatically
	LoginService loginService;
	
	@RequestMapping(value ="/login", method = RequestMethod.GET)
	public String ShowLoginMessage(ModelMap model){
		return "login";
	}
	
	@RequestMapping(value ="/login", method = RequestMethod.POST)
	public String showWelcomeMessage(ModelMap model, @RequestParam String firstname, 
			@RequestParam String password){
		boolean validateUser = loginService.validateUser(firstname, password);
		
		if(!validateUser) {
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}
		
		model.put("name", firstname);
		model.put("pwd", password);
		return "welcome";
	}
	
	/*@RequestMapping("/login")
	//@ResponseBody
	public String loginMessage(@RequestParam String name, ModelMap model){
		model.put("name", name);
		//System.out.println("name is: " + name);
		return "login";
	}*/
	
}
