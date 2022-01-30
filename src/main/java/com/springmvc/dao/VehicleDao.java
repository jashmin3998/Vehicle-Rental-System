package com.springmvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.model.Fourwheeler;
import com.springmvc.model.Twowheeler;

@Repository
public interface VehicleDao {

	//Two Wheelers
	public boolean checkTwoWheeresPresent();
	public List<Twowheeler> getAllTwoWheelers();
	public boolean addTwoWheelerToDB(Twowheeler tw);
	public boolean removeTwowheelerFromDB(String number);
	public Twowheeler getTwowheeler(String vehiclenumber);
	public boolean updateTwoWheeler(Twowheeler two);
	
	
	//Four Wheelers
	public boolean checkFourWheelersPresent();
	public List<Fourwheeler> getAllFourWheelers();
	public boolean addFourWheelerToDB(Fourwheeler four);
	public boolean deleteFourWheelerFromDB(String number);
	public Fourwheeler getFourWheeler(String vehiclenumber);
	public boolean updateFourWheeler(Fourwheeler four);
	
	public boolean checkTwoWheel(String email);
	public List<Twowheeler> getTwoWheelers(String email);
	public Twowheeler getTwowheelVendor(String vehiclenumber,String email);
	
	public boolean checkFourWheel(String email);
	public List<Fourwheeler> getFourWheelers(String email);
	public Fourwheeler getfourwheel(String vehiclenumber,String email);
}
