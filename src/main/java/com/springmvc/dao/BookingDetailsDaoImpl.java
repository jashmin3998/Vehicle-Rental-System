package com.springmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.handler.BookingHandler;
import com.springmvc.handler.PaymentHandler;
import com.springmvc.model.BookingDetails;
import com.springmvc.model.CardDetails;

@Repository
public class BookingDetailsDaoImpl implements BookingDetailsDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public BookingDetails maypaymentAndgetDetails(BookingDetails bookdetails, CardDetails card) {
		// TODO Auto-generated method stub
		String sql="select price from carddetails where cardNumber=? and cvv=? and e_mail=?";
		int price=-1;
		try {
			try {
			price=Integer.valueOf(jdbcTemplate.queryForObject(sql,new Object[] {card.getCardNumber(),card.getCvv(),card.getE_mail()}, String.class));
			}catch (Exception e) {
				// TODO: handle exception
				throw new PaymentHandler("No Wallet Found");
			}
			price=price-Integer.valueOf(bookdetails.getPrice());
			if(price<=0) {
				throw new PaymentHandler("Insufficient Amount");
				
			}
			else {
				card.setPrice(String.valueOf(price));
				sql="update carddetails set price=? where cardNumber=? and cvv=? and e_mail=?";
				int i=jdbcTemplate.update(sql,card.getPrice(),card.getCardNumber(),card.getCvv(),card.getE_mail());
				if(i>0) {
					sql="insert into bookdetails(name,useremail,vendorname,vendoremail,bookingDate,vehiclenumber,vehicletype,vehiclecolour,price) values(?,?,?,?,?,?,?,?,?)";
					int j=jdbcTemplate.update(sql,bookdetails.getName(),bookdetails.getUseremail(),bookdetails.getVendorname(),bookdetails.getVendoremail()
							,bookdetails.getBookingDate(),bookdetails.getVehiclenumber(),bookdetails.getVehicletype(),bookdetails.getVehiclecolour(),bookdetails.getPrice());
					if(j>0) {
						sql="select count(*) from bookdetails";
						int rows = jdbcTemplate.queryForObject(sql, Integer.class);
						sql = "select * from bookdetails limit "+(rows-1) + ",1";
						bookdetails=jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(BookingDetails.class));
						sql="delete from twowheeler where e_mail=?";
						int k=jdbcTemplate.update(sql, bookdetails.getVendoremail());
						if(k==0) {
							throw new BookingHandler("Vehicle is not present");
						}
					}
					else {
						throw new BookingHandler("Unable To Insert Booking Details");
					}
				}else {
					throw new PaymentHandler("Unable To Update Payment");
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			bookdetails=null;
		}
		return bookdetails;
	}
	@Override
	public BookingDetails makepaymentAndgetDetailsofFour(BookingDetails bookdetails, CardDetails card) {
		// TODO Auto-generated method stub
		String sql="select price from carddetails where cardNumber=? and cvv=? and e_mail=?";
		int price=-1;
		try {
			try {
			price=Integer.valueOf(jdbcTemplate.queryForObject(sql,new Object[] {card.getCardNumber(),card.getCvv(),card.getE_mail()}, String.class));
			}catch (Exception e) {
				// TODO: handle exception
				throw new PaymentHandler("No Wallet Found");
			}
			price=price-Integer.valueOf(bookdetails.getPrice());
			if(price<=0) {
				throw new PaymentHandler("Insufficient Amount");
				
			}
			else {
				card.setPrice(String.valueOf(price));
				sql="update carddetails set price=? where cardNumber=? and cvv=? and e_mail=?";
				int i=jdbcTemplate.update(sql,card.getPrice(),card.getCardNumber(),card.getCvv(),card.getE_mail());
				if(i>0) {
					sql="insert into bookdetails(name,useremail,vendorname,vendoremail,bookingDate,vehiclenumber,vehicletype,vehiclecolour,price) values(?,?,?,?,?,?,?,?,?)";
					int j=jdbcTemplate.update(sql,bookdetails.getName(),bookdetails.getUseremail(),bookdetails.getVendorname(),bookdetails.getVendoremail()
							,bookdetails.getBookingDate(),bookdetails.getVehiclenumber(),bookdetails.getVehicletype(),bookdetails.getVehiclecolour(),bookdetails.getPrice());
					if(j>0) {
						sql="select count(*) from bookdetails";
						int rows = jdbcTemplate.queryForObject(sql, Integer.class);
						sql = "select * from bookdetails limit "+(rows-1) + ",1";
						bookdetails=jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(BookingDetails.class));
						sql="delete from fourwheeler where e_mail=?";
						int k=jdbcTemplate.update(sql, bookdetails.getVendoremail());
						if(k==0) {
							throw new BookingHandler("Vehicle is not present");
						}
					}
					else {
						throw new BookingHandler("Unable To Insert Booking Details");
					}
				}else {
					throw new PaymentHandler("Unable To Update Payment");
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			bookdetails=null;
		}
		return bookdetails;
	}
	@Override
	public List<BookingDetails> viewAllBookings() {
		// TODO Auto-generated method stub
		String sql="select * from bookdetails";
		List<BookingDetails> lst=null;
		try {
			lst=jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BookingDetails.class));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			lst=null;
		}
		return lst;
	}
	@Override
	public List<BookingDetails> viewUserBookingDetails(String email) {
		// TODO Auto-generated method stub
		String sql="select * from bookdetails where useremail=?";
		List<BookingDetails> lst=null;
		try {
			lst=jdbcTemplate.query(sql, new Object[] {email},new BeanPropertyRowMapper<>(BookingDetails.class));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			lst=null;
		}
		return lst;
	}
	@Override
	public List<BookingDetails> viewVendorVehicleBookingDetails(String email) {
		// TODO Auto-generated method stub
		List<BookingDetails> book=null;
		String sql="select * from bookdetails where vendoremail=?";
		try {
			book=jdbcTemplate.query(sql, new Object[] {email}, new BeanPropertyRowMapper<>(BookingDetails.class));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			book=null;
		}
		return book;
	}
	

}
