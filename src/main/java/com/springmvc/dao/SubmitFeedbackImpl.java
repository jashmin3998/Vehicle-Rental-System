package com.springmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.model.Feedback;

@Repository
public class SubmitFeedbackImpl implements SubmitFeedback {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public boolean sendFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String sql="insert into feedback values(?,?,?,?,?)";
		try {
			int i=jdbcTemplate.update(sql, feedback.getUseremail(),feedback.getUsername(),feedback.getFeedback(),feedback.getRating(),feedback.getCurrentDate());
			flag=true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}
	@Override
	public List<Feedback> getAllFeedbacks() {
		// TODO Auto-generated method stub
		String sql="select * from feedback order by currentDate desc";
		List<Feedback> feedback=null;
		try {
			feedback=jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Feedback.class));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return feedback;
	}

}
