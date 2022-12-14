package com.example.SpringTA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringTA.model.User;
import com.example.SpringTA.service.IUserService;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	IUserService userService;
	
	@PostMapping("/insert")
	public User insertUser(@RequestBody User user) {
		return userService.insertUser(user);
	}
}
