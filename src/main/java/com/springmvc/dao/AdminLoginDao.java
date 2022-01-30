package com.springmvc.dao;

import org.springframework.stereotype.Repository;

import com.springmvc.model.Admin;

@Repository
public interface AdminLoginDao {

	public Admin adminLogin(String email,String password);
}
