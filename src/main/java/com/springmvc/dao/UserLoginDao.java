package com.springmvc.dao;

import org.springframework.stereotype.Repository;

import com.springmvc.model.User;

@Repository
public interface UserLoginDao {

	public User getUserFromDB(String email,String password);
}
