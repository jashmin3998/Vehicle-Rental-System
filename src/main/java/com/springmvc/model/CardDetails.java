package com.springmvc.model;

public class CardDetails {

	private String cardNumber;
	private String cardType;
	private String 	expirationMonth;
	private String 	expirationYear;
	private int cvv;
	private String price;
	private String e_mail;
	public CardDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CardDetails(String cardNumber, String cardType, String expirationMonth, String expirationYear, int cvv,
			String price, String e_mail) {
		super();
		this.cardNumber = cardNumber;
		this.cardType = cardType;
		this.expirationMonth = expirationMonth;
		this.expirationYear = expirationYear;
		this.cvv = cvv;
		this.price = price;
		this.e_mail = e_mail;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getExpirationMonth() {
		return expirationMonth;
	}
	public void setExpirationMonth(String expirationMonth) {
		this.expirationMonth = expirationMonth;
	}
	public String getExpirationYear() {
		return expirationYear;
	}
	public void setExpirationYear(String expirationYear) {
		this.expirationYear = expirationYear;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	@Override
	public String toString() {
		return "CardDetails [cardNumber=" + cardNumber + ", cardType=" + cardType + ", expirationMonth="
				+ expirationMonth + ", expirationYear=" + expirationYear + ", cvv=" + cvv + ", price=" + price
				+ ", e_mail=" + e_mail + "]";
	}
	
}
