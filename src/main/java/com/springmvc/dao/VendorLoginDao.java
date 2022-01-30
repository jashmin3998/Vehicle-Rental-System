package com.springmvc.dao;

import org.springframework.stereotype.Repository;

import com.springmvc.model.Vendor;

@Repository
public interface VendorLoginDao {

	public Vendor vendorLogin(String email,String password);
}
