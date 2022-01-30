package com.springmvc.model;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class User {
	private String name;
	private String e_mail;
	private Date DOB;
	private String password;
	private String address;
	private String phone_no;
	private String gender;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, String e_mail, Date dOB, String password, String address, String phone_no, String gender) {
		super();
		this.name = name;
		this.e_mail = e_mail;
		DOB = dOB;
		this.password = password;
		this.address = address;
		this.phone_no = phone_no;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", e_mail=" + e_mail + ", DOB=" + DOB + ", password=" + password + ", address="
				+ address + ", phone_no=" + phone_no + ", gender=" + gender + "]";
	}
	
	
}
