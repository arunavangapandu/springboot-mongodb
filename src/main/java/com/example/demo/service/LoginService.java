package com.example.demo.service;

import org.springframework.stereotype.Component;

// Spring Bean --- spring needs to instntiate this class, and managed by it, so declare it 
// as a spring bean.
@Component
public class LoginService {
	
	public boolean validateUser(String userId, String password) {
		return userId.equalsIgnoreCase("aruna") 
				&& password.equalsIgnoreCase("shreyan");
	}

}
