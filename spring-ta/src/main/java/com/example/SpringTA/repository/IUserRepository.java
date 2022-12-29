package com.example.SpringTA.repository;

import java.util.List;

import com.example.SpringTA.model.User;

public interface IUserRepository {

	User insertUser(User user);

	User loginUser(User user);

	User registerUser(User user);

	List<User> getAllUser();

	

}
