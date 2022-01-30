package com.springmvc.dao;

import org.springframework.stereotype.Repository;

import com.springmvc.model.User;

@Repository
public interface UserRegisterDao {

	public User saveUserToDB(User user);
}
