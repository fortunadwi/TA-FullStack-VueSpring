package com.example.SpringTA.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringTA.model.User;
import com.example.SpringTA.repository.IUserRepository;
import com.example.SpringTA.service.IUserService;

@Service
public class UserService implements IUserService {
	@Autowired
	IUserRepository userRepository;
	
	@Override
	public User insertUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.insertUser(user);
	}
}
