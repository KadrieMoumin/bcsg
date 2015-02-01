package com.bcsg.service;

import java.util.List;

import com.bcsg.model.BankCard;

public interface IBankCardService {

	public List<BankCard> getAllCardsSorted();
}
