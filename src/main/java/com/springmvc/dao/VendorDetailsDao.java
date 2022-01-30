package com.springmvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.model.Vendor;

@Repository
public interface VendorDetailsDao {

	public boolean checkVendors();
	public List<Vendor> getAllVendors();
	public boolean saveVendorToDB(Vendor vendor);
	public boolean deleteVendorFromDB(String email);
	public Vendor getVendor(String email);
	public boolean updateVendor(Vendor vendor);
}
