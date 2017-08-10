package com.rest.ws.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.ws.model.ApplicationLog;
import com.rest.ws.model.User;
import com.rest.ws.repository.AppLogRepository;
import com.rest.ws.repository.UserRepository;

@RestController
public class ApplicationController {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	AppLogRepository logRepo;
	
	@RequestMapping("/fetchlogs")
	public List<ApplicationLog> fetchlogs(@RequestParam("user") String username, @RequestParam("password") String password) {
		 
		User user = userRepo.findByUsernameAndPassword(username, password);
		
		if (user == null) {
			throw new IllegalArgumentException("Please check your credentilas!");
		}
		
		return (List<ApplicationLog>) logRepo.findAll();
	}
	
	@ExceptionHandler
	void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.UNAUTHORIZED.value());
	}
}

