package com.springmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.model.Vendor;
@Repository
public class VendorDetailsDaoImpl implements VendorDetailsDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public boolean checkVendors() {
		// TODO Auto-generated method stub
		String sql="select count(*) from vendor";
		int count=-1;
		try {
			count=jdbcTemplate.queryForObject(sql, Integer.class);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			count=-2;
		}
		if(count<=0) {
		return false;
		}
		return true;
	}
	@Override
	public List<Vendor> getAllVendors() {
		// TODO Auto-generated method stub
		String sql="select * from vendor";
		List<Vendor> vendors=null;
		try {
			vendors=jdbcTemplate.query(sql, new BeanPropertyRowMapper(Vendor.class));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			vendors=null;
		}
		return vendors;
	}
	@Override
	public boolean saveVendorToDB(Vendor vendor) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="insert into vendor values(?,?,?,?,?,?,?)";
		try {
			jdbcTemplate.update(sql,vendor.getName(),vendor.getE_mail(),vendor.getDOB(),
					vendor.getPassword(),vendor.getAddress(),vendor.getPhone_no(),vendor.getGender());
			flag=true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}
	@Override
	public boolean deleteVendorFromDB(String email) {
		// TODO Auto-generated method stub
		String sql="delete from vendor where e_mail=?";
		String sql1="delete from twowheeler where e_mail=?";
		String sql2="delete from fourwheeler where e_mail=?";
		boolean flag=false;
		try {
			jdbcTemplate.update(sql, email);
			jdbcTemplate.update(sql1,email);
			jdbcTemplate.update(sql2,email);
			flag=true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}
	@Override
	public Vendor getVendor(String email) {
		// TODO Auto-generated method stub
		String sql="select * from vendor where e_mail=?";
		Vendor vendor=null;
		try {
			vendor=jdbcTemplate.queryForObject(sql, new Object[] {email}, new BeanPropertyRowMapper<>(Vendor.class));
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			vendor=null;
		}
		return vendor;
	}
	@Override
	public boolean updateVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="update vendor set name=?,password=?,dob=?,address=?,phone_no=? where e_mail=?";
		try {
			jdbcTemplate.update(sql, vendor.getName(),vendor.getPassword(),vendor.getDOB(),vendor.getAddress(),vendor.getPhone_no(),vendor.getE_mail());
			flag=true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}

}
