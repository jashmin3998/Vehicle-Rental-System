package com.springmvc.model;

import java.sql.Date;

public class Feedback {

	public String useremail;
	public String username;
	public String feedback;
	public String rating;
	public Date currentDate;
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Feedback(String useremail, String username, String feedback, String rating, Date currentDate) {
		super();
		this.useremail = useremail;
		this.username = username;
		this.feedback = feedback;
		this.rating = rating;
		this.currentDate = currentDate;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public Date getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
	@Override
	public String toString() {
		return "Feedback [useremail=" + useremail + ", username=" + username + ", feedback=" + feedback + ", rating="
				+ rating + ", currentDate=" + currentDate + "]";
	}
	
}
