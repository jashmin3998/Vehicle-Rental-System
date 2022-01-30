package com.springmvc.model;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class BookingDetails {

	private long bookingId;
	private String name;
	private String useremail;
	private String vendorname;
	private String vendoremail;
	private Date bookingDate;
	private String vehiclenumber;
	private String vehicletype;
	private String vehiclecolour;
	private String price;
	public BookingDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookingDetails(long bookingId, String name, String useremail, String vendorname, String vendoremail,
			Date bookingDate, String vehiclenumber, String vehicletype, String vehiclecolour, String price) {
		super();
		this.bookingId = bookingId;
		this.name = name;
		this.useremail = useremail;
		this.vendorname = vendorname;
		this.vendoremail = vendoremail;
		this.bookingDate = bookingDate;
		this.vehiclenumber = vehiclenumber;
		this.vehicletype = vehicletype;
		this.vehiclecolour = vehiclecolour;
		this.price = price;
	}
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getVendorname() {
		return vendorname;
	}
	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}
	public String getVendoremail() {
		return vendoremail;
	}
	public void setVendoremail(String vendoremail) {
		this.vendoremail = vendoremail;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BookingDetails [bookingId=" + bookingId + ", name=" + name + ", useremail=" + useremail
				+ ", vendorname=" + vendorname + ", vendoremail=" + vendoremail + ", bookingDate=" + bookingDate
				+ ", vehiclenumber=" + vehiclenumber + ", vehicletype=" + vehicletype + ", vehiclecolour="
				+ vehiclecolour + ", price=" + price + "]";
	}
	
	
}
