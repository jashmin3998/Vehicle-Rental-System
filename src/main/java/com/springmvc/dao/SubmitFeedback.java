package com.springmvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.model.Feedback;
@Repository
public interface SubmitFeedback {

	public boolean sendFeedback(Feedback feedback);
	public List<Feedback> getAllFeedbacks();
}
