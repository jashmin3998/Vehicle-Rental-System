package com.springmvc.dao;

import org.springframework.stereotype.Repository;

import com.springmvc.model.CardDetails;

@Repository
public interface CardDetailsDao {

	public boolean addCardDetails(CardDetails cardDetails);
}
