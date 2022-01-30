package com.springmvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.model.CardDetails;

@Repository
public class CardDetailsDaoImpl implements CardDetailsDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public boolean addCardDetails(CardDetails cardDetails) {
		// TODO Auto-generated method stub
		int i = 0, j = 0;
		String sql = "select * from carddetails where e_mail=? and cardNumber=? and cvv=?";
		CardDetails result = null;

		try {
			result = jdbcTemplate.queryForObject(sql,
					new Object[] { cardDetails.getE_mail(), cardDetails.getCardNumber(),cardDetails.getCvv() },
					new BeanPropertyRowMapper<>(CardDetails.class));
			cardDetails.setPrice(String.valueOf(Integer.valueOf(result.getPrice()) + Integer.valueOf(cardDetails.getPrice())));
			sql = "update carddetails set price=? where e_mail=? and cardNumber=? and cvv=?";
			j = jdbcTemplate.update(sql, cardDetails.getPrice(),cardDetails.getE_mail(),
					cardDetails.getCardNumber(),cardDetails.getCvv());
		} catch (Exception e) {
			sql = "insert into carddetails values(?,?,?,?,?,?,?)";
			i = jdbcTemplate.update(sql, cardDetails.getCardNumber(), cardDetails.getCardType(),
					cardDetails.getExpirationMonth(), cardDetails.getExpirationYear(), cardDetails.getCvv(),
					cardDetails.getPrice(), cardDetails.getE_mail());
			e.printStackTrace();
		}
		if (i == 0 && j == 0)
			return false;
		return true;
	}

}
