package com.bcsg.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank_detail")
public class BankCard implements Serializable, Cloneable {

	private static final long serialVersionUID = -3092510565017537547L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "bank_name")
	private String bankName;

	@Column(name = "card_number")
	private String cardNumber;

	@Column(name = "expiry_date")
	private Date expiryDate;

	public BankCard() {
		super();
	}

	public BankCard(int id, String bankName, String cardNumber, Date expiryDate) {
		super();
		this.id = id;
		this.bankName = bankName;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Object clone(){  
	    try{  
	        return super.clone();  
	    }catch(Exception e){ 
	        return null; 
	    }
	}
}
