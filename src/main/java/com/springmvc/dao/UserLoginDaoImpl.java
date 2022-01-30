package com.springmvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.model.User;
@Repository
public class UserLoginDaoImpl implements UserLoginDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	public User getUserFromDB(String email, String password) {
		// TODO Auto-generated method stub
		String sql="select * from user where e_mail=? and password=?";
		User user=null;
		try {
			user=(User)jdbcTemplate.queryForObject(sql, new Object[] {email, password},new BeanPropertyRowMapper<>(User.class));
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			user=null;
		}
		return user;
	}

}
