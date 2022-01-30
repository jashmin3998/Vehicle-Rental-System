package com.springmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.model.Fourwheeler;
import com.springmvc.model.Twowheeler;
import com.springmvc.model.Vehicle;

@Repository
public class VehicleDaoImpl implements VehicleDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public boolean checkTwoWheeresPresent() {
		// TODO Auto-generated method stub
		String sql="select count(*) from twowheeler";
		int count=-1;
		try {
			count=jdbcTemplate.queryForObject(sql, Integer.class);
		}catch (Exception e) {
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
	public List<Twowheeler> getAllTwoWheelers() {
		// TODO Auto-generated method stub
		List<Twowheeler> lst=null;
		String sql="select * from twowheeler";
		try {
			lst=jdbcTemplate.query(sql, new BeanPropertyRowMapper(Twowheeler.class));
		}catch (Exception e) {
			// TODO: handle exception
			lst=null;
		}
		return lst;
	}
	@Override
	public boolean addTwoWheelerToDB(Twowheeler tw) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql2="select count(*) from vendor where e_mail=?";
		String sql="insert into twowheeler values(?,?,?,?,?,?,?)";
		String sql1="select count(*) from fourwheeler where vehiclenumber=? or enginenumber=? or chassisnumber=?";
		try {
			int count1=0;
			count1=jdbcTemplate.queryForObject(sql2, new Object[] {tw.getE_mail()}, Integer.class);
			if(count1>0) {
			int count=-1;
			count=jdbcTemplate.queryForObject(sql1,new Object[] {tw.getVehiclenumber(),tw.getEnginenumber(),tw.getChassisnumber()}, Integer.class);
			if(count==0) {
			jdbcTemplate.update(sql, tw.getVehiclenumber(),tw.getVehicletype(),tw.getVehiclecolour()
					,tw.getEnginenumber(),tw.getChassisnumber(),tw.getPrice(),tw.getE_mail());
			flag=true;
			}
			else {
				flag=false;
			}
			}
			else {
				flag=false;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}
	@Override
	public boolean removeTwowheelerFromDB(String number) {
		// TODO Auto-generated method stub
		String sql="delete from twowheeler where vehiclenumber=?";
		boolean flag=false;
		try {
			jdbcTemplate.update(sql, number);
			flag=true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}
	@Override
	public Twowheeler getTwowheeler(String vehiclenumber) {
		// TODO Auto-generated method stub

		Twowheeler vehicle=null;
		String sql="select * from twowheeler where vehiclenumber=?";
		try {
			vehicle=jdbcTemplate.queryForObject(sql, new Object[] {vehiclenumber},new BeanPropertyRowMapper<>(Twowheeler.class));
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			vehicle=null;
		}
		return vehicle;
	}
	@Override
	public boolean updateTwoWheeler(Twowheeler two) {
		// TODO Auto-generated method stub
		String sql="update twowheeler set vehicletype=?,vehiclecolour=?,enginenumber=?,chassisnumber=?,price=?,e_mail=? where vehiclenumber=?";
		String sql1="select count(*) from fourwheeler where vehiclenumber=? or enginenumber=? or chassisnumber=?";
		String sql2="select count(*) from vendor where e_mail=?";
		boolean flag=false;
		System.out.println(two);
		try {
			int count1=0;
			count1=jdbcTemplate.queryForObject(sql2, new Object[] {two.getE_mail()}, Integer.class);
			if(count1>0) {
			int count=-1;
			count=jdbcTemplate.queryForObject(sql1,new Object[] {two.getVehiclenumber(),two.getEnginenumber(),two.getChassisnumber()}, Integer.class);
			if(count==0) {
			jdbcTemplate.update(sql, two.getVehicletype(),two.getVehiclecolour(),two.getEnginenumber(),two.getChassisnumber(),two.getPrice(),two.getE_mail(),two.getVehiclenumber());
			flag=true;
			}
			else {
				flag=false;
			}
			}
			else {
				flag=false;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}
	@Override
	public boolean checkFourWheelersPresent() {
		// TODO Auto-generated method stub
		String sql="select count(*) from fourwheeler";
		int count=-1;
		try {
			count=jdbcTemplate.queryForObject(sql, Integer.class);
		}catch (Exception e) {
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
	public List<Fourwheeler> getAllFourWheelers() {
		// TODO Auto-generated method stub
		List<Fourwheeler> lst=null;
		String sql="select * from fourwheeler";
		try {
			lst=jdbcTemplate.query(sql, new BeanPropertyRowMapper(Fourwheeler.class));
		}catch (Exception e) {
			// TODO: handle exception
			lst=null;
		}
		return lst;
	}
	@Override
	public boolean addFourWheelerToDB(Fourwheeler four) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="insert into fourwheeler values(?,?,?,?,?,?,?)";
		String sql1="select count(*) from twowheeler where vehiclenumber=? or enginenumber=? or chassisnumber=?";
		String sql2="select count(*) from vendor where e_mail=?";
		try {
			int count1=0;
			count1=jdbcTemplate.queryForObject(sql2, new Object[] {four.getE_mail()}, Integer.class);
			if(count1>0) {
			int count=-1;
			count=jdbcTemplate.queryForObject(sql1, new Object[] {four.getVehiclenumber(),four.getEnginenumber(),four.getChassisnumber()}, Integer.class);
			if(count==0) {
			jdbcTemplate.update(sql, four.getVehiclenumber(),four.getVehicletype(),four.getVehiclecolour()
					,four.getEnginenumber(),four.getChassisnumber(),four.getPrice(),four.getE_mail());
			flag=true;
			}
			else {
				flag=false;
			}
			}else {
				flag=false;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}
	@Override
	public boolean deleteFourWheelerFromDB(String number) {
		// TODO Auto-generated method stub
		String sql="delete from fourwheeler where vehiclenumber=?";
		boolean flag=false;
		try {
			jdbcTemplate.update(sql, number);
			flag=true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}
	@Override
	public Fourwheeler getFourWheeler(String vehiclenumber) {
		// TODO Auto-generated method stub
		Fourwheeler fw=null;
		String sql="select * from fourwheeler where vehiclenumber=?";
		try {
			fw=jdbcTemplate.queryForObject(sql, new Object[] {vehiclenumber}, new BeanPropertyRowMapper<>(Fourwheeler.class));
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			fw=null;
		}
		return fw;
	}
	@Override
	public boolean updateFourWheeler(Fourwheeler four) {
		// TODO Auto-generated method stub
		String sql="update fourwheeler set vehicletype=?,vehiclecolour=?,enginenumber=?,chassisnumber=?,price=?,e_mail=? where vehiclenumber=?";
		String sql1="select count(*) from twowheeler where vehiclenumber=? or enginenumber=? or chassisnumber=?";
		String sql2="select count(*) from vendor where e_mail=?";
		boolean flag=false;
		try {
			int count1=0;
			count1=jdbcTemplate.queryForObject(sql2, new Object[] {four.getE_mail()}, Integer.class);
			if(count1>0) {
			int count=-1;
			count=jdbcTemplate.queryForObject(sql1,new Object[] {four.getVehiclenumber(),four.getEnginenumber(),four.getChassisnumber()}, Integer.class);
			if(count==0) {
			jdbcTemplate.update(sql, four.getVehicletype(),four.getVehiclecolour(),four.getEnginenumber(),four.getChassisnumber(),four.getPrice(),four.getE_mail(),four.getVehiclenumber());
			flag=true;
			}
			else {
				flag=false;
			}
			}
			else {
				flag=false;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}
	@Override
	public boolean checkTwoWheel(String email) {
		// TODO Auto-generated method stub
		String sql="select count(*) from twowheeler where e_mail=?";
		int count=-1;
		try {
			count=jdbcTemplate.queryForObject(sql,new Object[] {email}, Integer.class);
		}catch (Exception e) {
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
	public List<Twowheeler> getTwoWheelers(String email) {
		// TODO Auto-generated method stub
		List<Twowheeler> lst=null;
		String sql="select * from twowheeler where e_mail=?";
		try {
			lst=jdbcTemplate.query(sql,new Object[] {email}, new BeanPropertyRowMapper<>(Twowheeler.class));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			lst=null;
		}
		return lst;
	}
	
	@Override
	public Twowheeler getTwowheelVendor(String vehiclenumber, String email) {
		// TODO Auto-generated method stub
		String sql="select * from twowheeler where vehiclenumber=? and e_mail=?";
		Twowheeler two=null;
		try {
			two=jdbcTemplate.queryForObject(sql, new Object[] {vehiclenumber,email},new BeanPropertyRowMapper<>(Twowheeler.class));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			two=null;
		}
		return two;
	}
	@Override
	public boolean checkFourWheel(String email) {
		// TODO Auto-generated method stub
		String sql="select count(*) from fourwheeler where e_mail=?";
		int count=-1;
		try {
			count=jdbcTemplate.queryForObject(sql,new Object[] {email}, Integer.class);
		}catch (Exception e) {
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
	public List<Fourwheeler> getFourWheelers(String email) {
		// TODO Auto-generated method stub
		List<Fourwheeler> lst=null;
		String sql="select * from fourwheeler where e_mail=?";
		try {
			lst=jdbcTemplate.query(sql,new Object[] {email}, new BeanPropertyRowMapper<>(Fourwheeler.class));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			lst=null;
		}
		return lst;
	}
	@Override
	public Fourwheeler getfourwheel(String vehiclenumber, String email) {
		// TODO Auto-generated method stub
		String sql="select * from fourwheeler where vehiclenumber=? and e_mail=?";
		Fourwheeler four=null;
		try {
			four=jdbcTemplate.queryForObject(sql, new Object[] {vehiclenumber,email},new BeanPropertyRowMapper<>(Fourwheeler.class));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			four=null;
		}
		return four;
	}
	
}
