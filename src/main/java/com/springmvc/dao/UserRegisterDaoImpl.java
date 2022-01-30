package com.springmvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.model.User;

@Repository
public class UserRegisterDaoImpl implements UserRegisterDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public User saveUserToDB(User user) {
		// TODO Auto-generated method stub
		String sql="insert into user values(?,?,?,?,?,?,?)";
		String sql1="select * from user where e_mail=? and password=?";
		User user1=null;
		try {
		if(jdbcTemplate.update(sql, user.getName(),user.getE_mail(),user.getDOB(),user.getPassword()
				,user.getAddress(),user.getPhone_no(),user.getGender())==1) {
			user1=jdbcTemplate.queryForObject(sql1, new Object[] {user.getE_mail(),user.getPassword()}
			, new BeanPropertyRowMapper<>(User.class));
		}
		else {
			return null;
		}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			user1=null;
		}
		return user1;
	}

}
