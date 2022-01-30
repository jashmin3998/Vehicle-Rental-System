package com.springmvc.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.dao.AdminLoginDao;
import com.springmvc.dao.BookingDetailsDao;
import com.springmvc.dao.SubmitFeedback;
import com.springmvc.dao.VendorDetailsDao;
import com.springmvc.model.Admin;
import com.springmvc.model.BookingDetails;
import com.springmvc.model.Vendor;

@Controller
public class AdminController {

	@Autowired
	AdminLoginDao adminlogindao;
	
	@Autowired
	VendorDetailsDao vendorDetailsDao;
	
	@Autowired 
	Admin admin1;
	@Autowired
	SubmitFeedback sf;
	@Autowired
	BookingDetailsDao booking;
	
	@RequestMapping("/PayRentAndUse")
	public String welcome() {
		return "Welcome";
	}
	@RequestMapping("/adminloginpage")
	public String adminLoginPage() {
		return "adminlogin";
	}
	@ModelAttribute("date1")
	public String getDate1(){
		//System.out.println(customerDao.getEmailIds());
		Date dt=new Date();
		String i=String.valueOf(dt.getDate());
		String j=String.valueOf(dt.getMonth()+1);
		int y=dt.getYear()+1900-18;
		if(i.length()==1) {
			i="0"+i;
		}
		if(j.length()==1) {
			j="0"+j;
		}
		System.out.println(""+y+"-"+j+"-"+i);
		return ""+y+"-"+j+"-"+i;
	}

	@RequestMapping("/adminhomepage")
	public String goToAdminHomePage(@RequestParam("e_mail") String email,@RequestParam("password") String password, ModelMap model ) {
		Admin admin=null;
		if((admin=adminlogindao.adminLogin(email, password))!=null) {
			admin1=admin;
			model.addAttribute("admin", admin);
			return "adminhome";
		}
		else {
			model.addAttribute("message","Invalid Credentials");
			return "adminlogin";
		}
	}
	@RequestMapping("/viewVendors")
	public String viewVendor(ModelMap model) {
		if(vendorDetailsDao.checkVendors()) {
			List<Vendor> vendors=vendorDetailsDao.getAllVendors();
			model.addAttribute("empty1", 1);
			model.addAttribute("vendorsList", vendors);
			return "viewvendorpage";
		}
		model.addAttribute("empty1", 0);
		model.addAttribute("emptyvendor", "No Vendors Available!");
		return "viewvendorpage";
	}
	@RequestMapping("/adddetails")
	public String addVendor(Vendor vendor,ModelMap model) {
		model.addAttribute("vendordet", vendor);
		return "registervendor";
	}
	@RequestMapping("/registeredVendor")
	public String registerVendor(@ModelAttribute("vendordet")@Validated Vendor vendor,BindingResult br,ModelMap model) {
		if(br.hasErrors()) {
			return "registervendor";
		}
		if(vendorDetailsDao.saveVendorToDB(vendor)) {
			return "redirect:/viewVendors";
		}
		return "registervendor";
	}
	@GetMapping("/deletedetails")
	public String deleteVendor(@Param("email") String email) {
		System.out.println(email);
		if(vendorDetailsDao.deleteVendorFromDB(email)) {
			return "redirect:/viewVendors";
		}
		return "viewvendorpage";
	}
	@GetMapping("/updatedetails")
	public String updateVendor(@Param("email")String email,ModelMap model) {
		Vendor vendor=vendorDetailsDao.getVendor(email);
		model.addAttribute("vendor1", vendor);
		return "updatevendor";
	}
	@RequestMapping("/updatedVendor")
	public String updatedVendorDetails(@ModelAttribute("vendor1") Vendor vendor,BindingResult br,ModelMap model) {
		
		if(br.hasErrors()) {
			return "updatevendor";
		}
		if(vendorDetailsDao.updateVendor(vendor)) {
			return "redirect:/viewVendors";
		}
		model.addAttribute("error","Error Occured!");
		return "updatevendor";
	}
	@GetMapping("/viewdetails")
	public String viewVendorDetails(@Param("email") String email,ModelMap model) {
		Vendor vendor=vendorDetailsDao.getVendor(email);
		model.addAttribute("vendordetail", vendor);
		return "viewvendor";
	}
	@RequestMapping("/gotoviewvendorpage")
	public String gotoviewVendorpage() {
		return "redirect:/viewVendors";
	}
	@RequestMapping("/gotovendorhome")
	public String gotoAdminHome(ModelMap model) {
		model.addAttribute("admin", admin1);
		return "adminhome";
	}
	@RequestMapping("/vendorhome")
	public String homeVendor(ModelMap model) {
		model.addAttribute("admin", admin1);
		return "adminhome";
	}
	@RequestMapping("/logout")
	public String adminLogout() {
		return "Welcome";
	}
	
	@RequestMapping("/allbookings")
	public String viewAllBooking(ModelMap model) {
		model.addAttribute("bd",booking.viewAllBookings());
		return "adminviewbookings";
	}
	
	@RequestMapping("/viewfeedback")
	public String viewFeedBack(ModelMap model) {
		model.addAttribute("feedbacks", sf.getAllFeedbacks());
		return "viewuserfeedbacks";
	}
}
