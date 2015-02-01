package com.bcsg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bcsg.dao.IBankCardDao;
import com.bcsg.model.BankCard;

@Service
public class BankCardServiceImpl implements IBankCardService {

	private IBankCardDao bankCardDao;

	public BankCardServiceImpl(IBankCardDao bankCardDao) {
		this.bankCardDao = bankCardDao;
	}

	@Override
	@Transactional
	public List<BankCard> getAllCardsSorted() {

		List<BankCard> bankCardList = this.bankCardDao.getAllCardsSorted();
		
		return maskCardNumbers(bankCardList);

	}

	private List<BankCard> maskCardNumbers(List<BankCard> list) {

		List<BankCard> maskedList = new ArrayList<BankCard>();
		
		BankCard copyOfBankCard = null;
		for (BankCard card : list) {

			copyOfBankCard = (BankCard)(card.clone());
			
			String cardNumber = copyOfBankCard.getCardNumber();
			char type = cardNumber.charAt(0);
			int startlen = 0, endlen = 0, cardNumberlen = cardNumber.length();

			switch (type) {
			case '5':
				startlen = 2;
				endlen = cardNumberlen;
				break;
			case '4':
				startlen = 5;
				endlen = cardNumberlen;
				break;
			case '3':
				startlen = 0;
				endlen = 14;
				break;
			default :
				break;

			}
			
			StringBuffer maskedCardNumbers= new StringBuffer(cardNumber);
			for(int i=startlen; i<endlen; i++){
				if(maskedCardNumbers.charAt(i)!='-'){
				
					maskedCardNumbers.replace(i, i+1, "X");
				}
			}
			
			copyOfBankCard.setCardNumber(maskedCardNumbers.toString());
			maskedList.add(copyOfBankCard);
		}

		return maskedList;
	}
}
