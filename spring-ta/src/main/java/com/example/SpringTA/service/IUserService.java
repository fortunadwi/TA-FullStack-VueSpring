package com.example.SpringTA.service;

import java.util.List;

import com.example.SpringTA.model.User;

public interface IUserService {

	public User insertUser(User user);

	public User loginUser(User user);

	public User registerUser(User user);

	public List<User> getAllUser();

	
	
}
