package com.example.SpringTA.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.SpringTA.model.User;
import com.example.SpringTA.repository.IUserRepository;

@Repository
public class UserRepository implements IUserRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public User insertUser(User user) {
		// TODO Auto-generated method stub
				String query = "INSERT INTO tb_user(email, nama, password) "
						+ "VALUES(?, ?, ?)";
				jdbcTemplate.update(query, new Object[] {user.getEmail(), user.getNama(), user.getPassword()});
				return user;
	}
}
