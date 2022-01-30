package com.springmvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.model.BookingDetails;
import com.springmvc.model.CardDetails;

@Repository
public interface BookingDetailsDao {

	public BookingDetails maypaymentAndgetDetails(BookingDetails bookdetails ,CardDetails card);
	public BookingDetails makepaymentAndgetDetailsofFour(BookingDetails bookdetails,CardDetails card);
	public List<BookingDetails> viewAllBookings();
	public List<BookingDetails> viewUserBookingDetails(String email);
	public List<BookingDetails> viewVendorVehicleBookingDetails(String email);
}
