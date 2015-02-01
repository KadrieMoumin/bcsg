package com.bcsg.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bcsg.model.BankCard;
import com.bcsg.service.IBankCardService;
import com.bcsg.spring.config.ApplicationContextConfigTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationContextConfigTest.class)
public class BankCardServiceTest {

	@Autowired
	private IBankCardService bankCardService;

	// 1- test - list not empty
	// - list size is 5
	@Test
	public void test_getAllCardsDetail() {

		List<BankCard> bankCardList = bankCardService.getAllCardsSorted();

		Assert.assertNotNull(bankCardList.size());
		Assert.assertEquals(4, bankCardList.size());

	}

	// 2- test- list is sorted
	// - list all elements
	@Test
	public void test_sortedByExpiryDate() {
		List<BankCard> bankCardList = bankCardService.getAllCardsSorted();
		Assert.assertNotNull(bankCardList.size());
		Assert.assertEquals(3, bankCardList.get(0).getId());
		Assert.assertEquals(1, bankCardList.get(1).getId());
		Assert.assertEquals(2, bankCardList.get(2).getId());
		Assert.assertEquals(4, bankCardList.get(3).getId());
	}

	// 3- test - card numbers are masked
	@Test
	public void test_cardNumbersMasked() {
		
		List<BankCard> bankCardList = bankCardService.getAllCardsSorted();
		Assert.assertNotNull(bankCardList.size());
		Assert.assertEquals("XXXX-XXXX-XXXX-345", bankCardList.get(0).getCardNumber());
		Assert.assertEquals("56XX-XXXX-XXXX-XXXX", bankCardList.get(1).getCardNumber());
		Assert.assertEquals("4519-XXXX-XXXX-XXXX", bankCardList.get(2).getCardNumber());
		Assert.assertEquals("XXXX-XXXX-XXXX-355", bankCardList.get(3).getCardNumber());

	}
}
