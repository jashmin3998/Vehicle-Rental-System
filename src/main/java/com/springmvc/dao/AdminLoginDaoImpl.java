package com.springmvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.model.Admin;

@Repository
public class AdminLoginDaoImpl implements AdminLoginDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public Admin adminLogin(String email, String password) {
		// TODO Auto-generated method stub
		Admin admin=null;
		String sql="select * from admin where e_mail=? and password=?";
		try {
			admin=(Admin)jdbcTemplate.queryForObject(sql, new Object[] {email, password},new BeanPropertyRowMapper<>(Admin.class));
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			admin=null;
		}
		return admin;
	}

}
