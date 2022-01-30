package com.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.dao.BookingDetailsDao;
import com.springmvc.dao.CardDetailsDao;
import com.springmvc.dao.SubmitFeedback;
import com.springmvc.dao.UserLoginDao;
import com.springmvc.dao.UserRegisterDao;
import com.springmvc.dao.VehicleDao;
import com.springmvc.dao.VendorDetailsDao;
import com.springmvc.model.BookingDetails;
import com.springmvc.model.CardDetails;
import com.springmvc.model.Feedback;
import com.springmvc.model.Fourwheeler;
import com.springmvc.model.Twowheeler;
import com.springmvc.model.User;
import com.springmvc.model.Vendor;

@Controller
public class UserController {
	
	@Autowired
	UserLoginDao userLoginDao;
	
	@Autowired
	CardDetailsDao cardDetailsDao;
	
	@Autowired
	VehicleDao vehicleDao;
	
	@Autowired
	User users;
	
	@Autowired
	BookingDetails bookingdetails1;
	
	@Autowired
	SubmitFeedback submit;
	
	@Autowired
	VendorDetailsDao vendordao;
	
	@Autowired
	BookingDetailsDao bdd;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
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



	@RequestMapping("/userloginpage")
	public String adminLoginPage() {
		return "userlogin";
	}
	@RequestMapping("/registerUser")
	public String gotoregister(User user,ModelMap model) {
		model.addAttribute("user", user);
		return "userregister";
	}
	@Autowired
	UserRegisterDao userregisterdao;
	@RequestMapping("/registeredUser")
	public String gotowelcomepage(@ModelAttribute("user") @Validated User user,BindingResult br, ModelMap model) {
		if(br.hasErrors()) {
			model.addAttribute("error", "Register Again");
			return "userregister";
		}
		User user1=null;
		if((user1=userregisterdao.saveUserToDB(user))!=null) {
			users=user1;
			model.addAttribute("user", user1);
			return "userhomepage";
		}
		model.addAttribute("error", "Register Again");

		return "userregister";
		
	}
	@RequestMapping("/userhomepage")
	public String gotoUserhome(@RequestParam("e_mail")String email,@RequestParam("password")String password,ModelMap model) {
		User user=null;
		if((user=userLoginDao.getUserFromDB(email, password))!=null) {
			users=user;
			model.addAttribute("user", user);
			return "userhomepage";
		}
		model.addAttribute("message", "Invalid Credentials");
		return "userlogin";
	}
	
	@RequestMapping("/wallet")
	public String addMoney(@ModelAttribute("card") CardDetails card,ModelMap model) {
		model.addAttribute("card", card);
		model.addAttribute("e_mail", users.getE_mail());
		return "cardDetails";
	}
	
	@RequestMapping("/acceptCardDetails")
	public String addMoneyToWallet(@ModelAttribute("card") @Validated CardDetails card, BindingResult br, ModelMap model) {
		if(br.hasErrors()) {
			return "cardDetails";
		}
		if(cardDetailsDao.addCardDetails(card)) {
			model.addAttribute("user", users);
			return "userhomepage";
		}
		model.addAttribute("error", "Amount Not Added!!");
		return "userhomepage";
	}
	
	@RequestMapping("/selectVehicle")
	public String selectwheeler() {
		return "uservehicleselect";
	}
	
	@RequestMapping("/selecttwowheeler")
	public String selectTwowheeler(ModelMap model) {
		if (vehicleDao.checkTwoWheeresPresent()) {
			List<Twowheeler> twowheeler = vehicleDao.getAllTwoWheelers();
			model.addAttribute("empty2", 1);
			model.addAttribute("twowheel", twowheeler);
			return "userselecttwowheel";
		}
		model.addAttribute("empty2", 0);
		model.addAttribute("emptytwo", "No TwoWheelers Available!");
		return "userselecttwowheel";
	}
	
	@RequestMapping("/gotouserhome")
	public String gotoUserHome(ModelMap model) {
		model.addAttribute("user", users);
		return "userhomepage";
	}
	
	@RequestMapping("/backtouserVehicleType")
	public String gotoVehicleSelectPage() {
		return "uservehicleselect";
	}
	@RequestMapping("/selectfourwheeler")
	public String selectFourwheeler(ModelMap model) {
		if(vehicleDao.checkFourWheelersPresent()) {
			List<Fourwheeler> fourwheelers=vehicleDao.getAllFourWheelers();
			model.addAttribute("empty3", 1);
			model.addAttribute("fourwheel", fourwheelers);
			return "userselectfourwheel";
		}
		model.addAttribute("empty3", 0);
		model.addAttribute("emptyfour", "No Four Wheelers Available!");
		return "userselectfourwheel";
	}
	@GetMapping("/userviewtwowheeler")
	public String userviewtwowheel(@Param("vehiclenumber") String vehiclenumber,ModelMap model) {
		Twowheeler two=vehicleDao.getTwowheeler(vehiclenumber);
		model.addAttribute("two", two);
		return "userviewtwowheel";
	}
	@ModelAttribute("date")
	public String getDate(){
		//System.out.println(customerDao.getEmailIds());
		Date today=new Date();
		Date dt=new Date(today.getTime()+(1000*60*60*24));
		String i=String.valueOf(dt.getDate());
		String j=String.valueOf(dt.getMonth()+1);
		int y=dt.getYear()+1900;
		if(i.length()==1) {
			i="0"+i;
		}
		if(j.length()==1) {
			j="0"+j;
		}
		System.out.println(""+y+"-"+j+"-"+i);
		return ""+y+"-"+j+"-"+i;
	}
	@ModelAttribute("date2")
	public String getDate2(){
		//System.out.println(customerDao.getEmailIds());
		Date today=new Date();
		Date dt=new Date(today.getTime()+(1000*60*60*24*14));
		String i=String.valueOf(dt.getDate());
		String j=String.valueOf(dt.getMonth()+1);
		int y=dt.getYear()+1900;
		if(i.length()==1) {
			i="0"+i;
		}
		if(j.length()==1) {
			j="0"+j;
		}
		System.out.println(""+y+"-"+j+"-"+i);
		return ""+y+"-"+j+"-"+i;
	}
	@ModelAttribute("today")
	public String getTodayDate(){
		//System.out.println(customerDao.getEmailIds());
		Date dt=new Date();
		String i=String.valueOf(dt.getDate());
		String j=String.valueOf(dt.getMonth()+1);
		int y=dt.getYear()+1900;
		if(i.length()==1) {
			i="0"+i;
		}
		if(j.length()==1) {
			j="0"+j;
		}
		System.out.println(""+y+"-"+j+"-"+i);
		return ""+y+"-"+j+"-"+i;
	}
	
	@GetMapping("/booktwowheeler")
	public String booktwo(@Param("vehiclenumber") String vehiclenumber,ModelMap model,BookingDetails book) {
		Twowheeler two=vehicleDao.getTwowheeler(vehiclenumber);
		Vendor ven=vendordao.getVendor(two.getE_mail());
		model.addAttribute("two", two);
		model.addAttribute("vendor", ven);
		model.addAttribute("user", users);
		model.addAttribute("bookdetails", book);
		return "bookingtwowheel";
	}
	
	@RequestMapping("paytwo")
	public String payForTwo(@ModelAttribute("bookdetails")@Validated BookingDetails bookdetails,ModelMap model,BindingResult br,CardDetails cd) {
		if(br.hasErrors()) {
			return "bookingtwowheel";
		}
		bookingdetails1=bookdetails;
		model.addAttribute("price", bookdetails.getPrice());
		model.addAttribute("e_mail", users.getE_mail());
		model.addAttribute("card", cd);
		return "payment";
	}
	
	@RequestMapping("/makePayment")
	public String doPayment(@ModelAttribute("card") @Validated CardDetails card,BindingResult br,ModelMap model) {
		if(br.hasErrors()) {
			return "redirect:/selecttwowheeler";
		}
		BookingDetails bd=bdd.maypaymentAndgetDetails(bookingdetails1, card);
		if(bd==null) {
			return "redirect:/selecttwowheeler";
		}
		bookingdetails1=bd;
		model.addAttribute("book", bd);
		return "receipt";
	}
	
	@GetMapping("/userviewfourwheeler")
	public String userViewFour(@Param("vehiclenumber") String vehiclenumber,ModelMap model) {
		Fourwheeler four=vehicleDao.getFourWheeler(vehiclenumber);
		model.addAttribute("four", four);
		return "userviewfourwheel";
	}
	@GetMapping("/bookfourwheeler")
	public String bookFourWheel(@Param("vehiclenumber") String vehiclenumber,ModelMap model,BookingDetails book) {
		Fourwheeler four=vehicleDao.getFourWheeler(vehiclenumber);
		Vendor ven=vendordao.getVendor(four.getE_mail());
		model.addAttribute("four", four);
		model.addAttribute("vendor", ven);
		model.addAttribute("user", users);
		model.addAttribute("bookdet", book);
		return "bookingfourwheel";
	}
	@RequestMapping("/payfour")
	public String bookforFour(@ModelAttribute("bookdet")@Validated BookingDetails bookdet,ModelMap model,BindingResult br,CardDetails cd) {
		if(br.hasErrors()) {
			return "bookingfourwheel";
		}
		bookingdetails1=bookdet;
		model.addAttribute("price", bookdet.getPrice());
		model.addAttribute("e_mail", users.getE_mail());
		model.addAttribute("card", cd);
		return "paymentforFour";
	}
	@RequestMapping("/makePaymentforFour")
	public String payForFourWheel(@ModelAttribute("card") @Validated CardDetails card,BindingResult br,ModelMap model) {
		if(br.hasErrors()) {
			return "redirect:/selectfourwheeler";
		}
		BookingDetails bd=bdd.makepaymentAndgetDetailsofFour(bookingdetails1, card);
		if(bd==null) {
			return "redirect:/selectfourwheeler";
		}
		bookingdetails1=bd;
		model.addAttribute("book", bd);
		return "receiptforfour";
	}
	
	@RequestMapping("/usermyBookings")
	public String userBookings(ModelMap model) {
		List<BookingDetails> bd=bdd.viewUserBookingDetails(users.getE_mail());
		model.addAttribute("bd", bd);
		return "userbookings";
	}
	
	@RequestMapping("/givefeedback")
	public String giveFeedback(Feedback feedback,ModelMap model) {
		model.addAttribute("name",users.getName());
		model.addAttribute("email", users.getE_mail());
		model.addAttribute("feedback1", feedback);
		return "givefeedbackpage";
	}
	
	@RequestMapping("/submitfeedback")
	public String submitFeedback(@ModelAttribute("feedback1") Feedback feedback1,BindingResult br,ModelMap model) {
		if(br.hasErrors()) {
			return "givefeedbackpage";
		}
		System.out.println(feedback1);
		if(submit.sendFeedback(feedback1)) {
			return "redirect:/gotouserhome";
		}
		return "givefeedbackpage";
	}
}
