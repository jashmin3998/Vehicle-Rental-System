package com.springmvc.model;

public class Vehicle {

	private String vehiclenumber;
	private String vehicletype;
	private String vehiclecolour;
	private String enginenumber;
	private String chassisnumber;
	private String price;
	private String e_mail;
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vehicle(String vehiclenumber, String vehicletype, String vehiclecolour, String enginenumber,
			String chassisnumber, String price, String e_mail) {
		super();
		this.vehiclenumber = vehiclenumber;
		this.vehicletype = vehicletype;
		this.vehiclecolour = vehiclecolour;
		this.enginenumber = enginenumber;
		this.chassisnumber = chassisnumber;
		this.price = price;
		this.e_mail = e_mail;
	}
	public String getVehiclenumber() {
		return vehiclenumber;
	}
	public void setVehiclenumber(String vehiclenumber) {
		this.vehiclenumber = vehiclenumber;
	}
	public String getVehicletype() {
		return vehicletype;
	}
	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}
	public String getVehiclecolour() {
		return vehiclecolour;
	}
	public void setVehiclecolour(String vehiclecolour) {
		this.vehiclecolour = vehiclecolour;
	}
	public String getEnginenumber() {
		return enginenumber;
	}
	public void setEnginenumber(String enginenumber) {
		this.enginenumber = enginenumber;
	}
	public String getChassisnumber() {
		return chassisnumber;
	}
	public void setChassisnumber(String chassisnumber) {
		this.chassisnumber = chassisnumber;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	@Override
	public String toString() {
		return "Vehicle [vehiclenumber=" + vehiclenumber + ", vehicletype=" + vehicletype + ", vehiclecolour="
				+ vehiclecolour + ", enginenumber=" + enginenumber + ", chassisnumber=" + chassisnumber + ", price="
				+ price + ", e_mail=" + e_mail + "]";
	}
		
}
