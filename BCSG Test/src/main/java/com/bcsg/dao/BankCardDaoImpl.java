package com.bcsg.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bcsg.model.BankCard;

@Repository
public class BankCardDaoImpl implements IBankCardDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<BankCard> getAllCardsSorted() {

		List<BankCard> list = sessionFactory.getCurrentSession()
				.createCriteria(BankCard.class)
				.addOrder(Order.desc("expiryDate")).list();

		return list;

	}

}
