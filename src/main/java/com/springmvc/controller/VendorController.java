package com.springmvc.controller;

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

import com.springmvc.dao.BookingDetailsDao;
import com.springmvc.dao.VehicleDao;
import com.springmvc.dao.VendorLoginDao;
import com.springmvc.model.BookingDetails;
import com.springmvc.model.Fourwheeler;
import com.springmvc.model.Twowheeler;
import com.springmvc.model.Vehicle;
import com.springmvc.model.Vendor;

@Controller
public class VendorController {

	@Autowired
	VehicleDao vehicleDao;
	
	@Autowired
	Vendor vendor1;

	@Autowired
	VendorLoginDao vendorLoginDao;
	
	@Autowired
	BookingDetailsDao bookdetdao;

	@RequestMapping("/vendorloginpage")
	public String vendorLoginPage() {
		return "vendorlogin";
	}

	@RequestMapping("/vendorhomepage")
	public String vendorHome(@RequestParam("e_mail") String email, @RequestParam("password") String password,
			ModelMap model) {
		Vendor vendor = null;
		if ((vendor = vendorLoginDao.vendorLogin(email, password)) != null) {
			model.addAttribute("vendorlog", vendor);
			vendor1=vendor;
			return "vendorhome";
		}
		model.addAttribute("message", "Invalid Credentials");
		return "vendorlogin";
	}

	//Admin View Vehicle
	@RequestMapping("/viewVehileType")
	public String selectVehicle() {
		return "vehicleselect";
	}

	

	@RequestMapping("/twowheelers1")
	public String gotoTwowheeler(ModelMap model) {
		if (vehicleDao.checkTwoWheeresPresent()) {
			List<Twowheeler> twowheeler = vehicleDao.getAllTwoWheelers();
			model.addAttribute("empty2", 1);
			model.addAttribute("twowheel", twowheeler);
			return "twowheelers";
		}
		model.addAttribute("empty2", 0);
		model.addAttribute("emptytwo", "No TwoWheelers Available!");
		return "twowheelers";
	}

	@RequestMapping("/addtwowheeler")
	public String addTwo(Twowheeler tw, ModelMap model) {
		model.addAttribute("twowheel", tw);
		return "twowheelerregister";
	}

	@RequestMapping("/registeredTwowheeler")
	public String registertwo(@ModelAttribute("twowheel") @Validated Twowheeler tw, BindingResult br, ModelMap model) {
		if (br.hasErrors()) {
			return "twowheelerregister";
		}
		if (vehicleDao.addTwoWheelerToDB(tw)) {
			return "redirect:/twowheelers1";
		}
		model.addAttribute("error", "Invalid Inputs");
		return "twowheelerregister";
	}

	@GetMapping("/deletetwowheeler")
	public String deleteTwo(@Param("vehiclenumber") String vehiclenumber) {
		System.out.println(vehiclenumber);
		if (vehicleDao.removeTwowheelerFromDB(vehiclenumber)) {
			return "redirect:/twowheelers1";
		}
		return "twowheelers";
	}

	@GetMapping("/viewtwowheeler")
	public String viewTwo(@Param("vehiclenumber") String vehiclenumber, ModelMap model) {
		Twowheeler twowheeler = vehicleDao.getTwowheeler(vehiclenumber);
		model.addAttribute("tw", twowheeler);
		return "viewtwowheel";
	}

	@GetMapping("/updatetwowheeler")
	public String updateTwo(@Param("vehiclenumber") String vehiclenumber, ModelMap model) {
		Twowheeler twowheeler = vehicleDao.getTwowheeler(vehiclenumber);
		model.addAttribute("tw", twowheeler);
		return "twowheelerupdate";
	}

	@RequestMapping("/updatedTwowheeler")
	public String updatedTwo(@ModelAttribute("tw") @Validated Twowheeler two, BindingResult br, ModelMap model) {

		if (br.hasErrors()) {
			return "twowheelerupdate";
		}
		if (vehicleDao.updateTwoWheeler(two)) {
			return "redirect:/twowheelers1";
		} else {
			model.addAttribute("error", "Error Occured!");
			return "twowheelerupdate";
		}
	}

	@RequestMapping("/fourwheelers1")
	public String gotofourwheel(ModelMap model) {
		if (vehicleDao.checkFourWheelersPresent()) {
			List<Fourwheeler> fourwheeler = vehicleDao.getAllFourWheelers();
			model.addAttribute("empty3", 1);
			model.addAttribute("fourwheel", fourwheeler);
			return "fourwheelers";
		}
		model.addAttribute("empty3", 0);
		model.addAttribute("emptyfour", "No Four Wheelers Available!");
		return "fourwheelers";
	}

	@RequestMapping("/addfourwheeler")
	public String registerFourwheel(Fourwheeler four, ModelMap model) {
		model.addAttribute("four", four);
		return "registerfourwheeler";
	}

	@RequestMapping("/registeredfourwheeler")
	public String addFourwheel(@ModelAttribute("four") @Validated Fourwheeler four, BindingResult br, ModelMap model) {
		if (br.hasErrors()) {
			return "registerfourwheeler";
		}
		if (vehicleDao.addFourWheelerToDB(four)) {
			return "redirect:/fourwheelers1";
		}
		model.addAttribute("error", "Invalid Inputs");
		return "registerfourwheeler";
	}

	@GetMapping("/deletefourwheeler")
	public String deleteFour(@Param("vehiclenumber") String vehiclenumber) {
		System.out.println(vehiclenumber);
		if (vehicleDao.deleteFourWheelerFromDB(vehiclenumber)) {
			return "redirect:/fourwheelers1";
		}
		return "fourwheelers";
	}

	@GetMapping("/viewfourwheeler")
	public String viewFourWheelers(@Param("vehiclenumber") String vehiclenumber, ModelMap model) {
		Fourwheeler fw = vehicleDao.getFourWheeler(vehiclenumber);
		model.addAttribute("four", fw);
		return "viewfourwheelers";
	}

	@GetMapping("/updatefourwheeler")
	public String updatefourw(@Param("vehiclenumber") String vehiclenumber, ModelMap model) {
		Fourwheeler fourw = vehicleDao.getFourWheeler(vehiclenumber);
		model.addAttribute("four1", fourw);
		return "updatefourwheel";
	}

	@RequestMapping("/updatedFourwheeler")
	public String updatedfourwheeler(@ModelAttribute("four1") @Validated Fourwheeler four1, BindingResult br,
			ModelMap model) {
		System.out.println(four1);
		if (br.hasErrors()) {
			return "updatefourwheel";
		}
		if (vehicleDao.updateFourWheeler(four1)) {
			System.out.println(four1);

			return "redirect:/fourwheelers1";
		} else {
			model.addAttribute("error", "Error Occured!");
			System.out.println(four1);

			return "updatefourwheel";
		}
	}
	
	
	//Vendor
	@RequestMapping("/twowheelersvendor")
	public String viewTwowheelVendor(ModelMap model) {
		if (vehicleDao.checkTwoWheel(vendor1.getE_mail())) {
			List<Twowheeler> twowheeler = vehicleDao.getTwoWheelers(vendor1.getE_mail());
			model.addAttribute("empty2", 1);
			model.addAttribute("twowheel", twowheeler);
			return "twowheelersVendors";
		}
		model.addAttribute("empty2", 0);
		model.addAttribute("emptytwo", "No TwoWheelers Available!");
		return "twowheelersVendors";
	}
	
	@RequestMapping("/gotovendorselect")
	public String gotoSelect() {
		return "vehicleselectVendor";
	}
	@RequestMapping("/Vhome")
	public String gotoVhome(ModelMap model) {
		model.addAttribute("vendorlog", vendor1);
		return "vendorhome";
	}
	@GetMapping("/updatetwowheelervendor")
	public String updateVendorvehicle(@Param("vehiclenumber")String vehiclenumber,ModelMap model) {
		Twowheeler two=vehicleDao.getTwowheelVendor(vehiclenumber, vendor1.getE_mail());
		model.addAttribute("two", two);
		return "updatedtwowheel";
	}

	@RequestMapping("/twowheelUpdate")
	public String updatetwow(@ModelAttribute("two") Twowheeler two,BindingResult br,ModelMap model)
	{
		if(br.hasErrors()) {
			return "updatedtwowheel";
		}
		if(vehicleDao.updateTwoWheeler(two)) {
			return "redirect:/twowheelersvendor";
		}
		else {
			model.addAttribute("error", "Invalid Input");
			return "updatedtwowheel";
		}
	}
	@GetMapping("/deletetwowheelVendors")
	public String deletetwowh(@Param("vehiclenumber") String vehiclenumber)
	{
		vehicleDao.removeTwowheelerFromDB(vehiclenumber);
		return "redirect:/twowheelersvendor";
	}
	@GetMapping("/viewtwowheelerVendor")
	public String viewtwo(@Param("vehiclenumber") String vehiclenumber,ModelMap model)
	{
		Twowheeler twow=vehicleDao.getTwowheeler(vehiclenumber);
		model.addAttribute("two", twow);
		return "viewtwo";
	}
	@RequestMapping("/fourwheelersvendor")
	public String viewFourwheelerVendor(ModelMap model) {
		List<Fourwheeler> four=null;
		if(vehicleDao.checkFourWheel(vendor1.getE_mail())) {
			four=vehicleDao.getFourWheelers(vendor1.getE_mail());
			model.addAttribute("empty2", 1);
			model.addAttribute("four", four);
			return "fourwheelersVendors";
		}
		model.addAttribute("empty2", 0);
		model.addAttribute("emptytwo", "No Four Wheelers Available!");
		return "fourwheelersVendors";
	}
	@GetMapping("/deletefourwheelVendors")
	public String deletefour(@Param("vehiclenumber")String vehiclenumber) {
		vehicleDao.deleteFourWheelerFromDB(vehiclenumber);
		return "redirect:/fourwheelersvendor";
	}
	@GetMapping("/updatefourwheelervendor")
	public String updatefour(@Param("vehiclenumber") String vehiclenumber,ModelMap model)
	{
		Fourwheeler four=vehicleDao.getfourwheel(vehiclenumber, vendor1.getE_mail());
		model.addAttribute("four", four);
		return "updated4wheel";
	}
	
	@RequestMapping("fourwheelUpdate1")
	public String fourwheelupdt(@ModelAttribute("four")@Validated Fourwheeler four,BindingResult br,ModelMap model)
	{
		if(br.hasErrors()) {
			return "updated4wheel";
		}
		if(vehicleDao.updateFourWheeler(four)) {
			return "redirect:/fourwheelersvendor";
		}
		else {
			model.addAttribute("error", "Invalid Input");
			return "updated4wheel";
		}
		
	}
	@GetMapping("/viewfourwheelerVendor")
	public String view4wheel(@Param("vehiclenumber") String vehiclenumber,ModelMap model) {
		Fourwheeler four=vehicleDao.getFourWheeler(vehiclenumber);
		model.addAttribute("four", four);
		return "viewfour";
	}
	
	@RequestMapping("/viewVendorBooking")
	public String viewvendorbook(ModelMap model) {
		List<BookingDetails> bd=bookdetdao.viewVendorVehicleBookingDetails(vendor1.getE_mail());
		model.addAttribute("book", bd);
		return "viewvendorvehiclebooking";
	}
}
