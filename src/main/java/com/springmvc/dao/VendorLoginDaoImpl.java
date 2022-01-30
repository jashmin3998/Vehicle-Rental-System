package com.springmvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.model.Vendor;

@Repository
public class VendorLoginDaoImpl implements VendorLoginDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public Vendor vendorLogin(String email, String password) {
		// TODO Auto-generated method stub
		String sql="select * from vendor where e_mail=? and password=?";
		Vendor vendor=null;
		try {
			vendor=jdbcTemplate.queryForObject(sql, new Object[] {email,password},new BeanPropertyRowMapper<>(Vendor.class));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			vendor=null;
		}
		return vendor;
	}

}
