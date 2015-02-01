package com.bcsg.dao;

import java.util.List;

import com.bcsg.model.BankCard;

public interface IBankCardDao {
	public List<BankCard> getAllCardsSorted();
}
