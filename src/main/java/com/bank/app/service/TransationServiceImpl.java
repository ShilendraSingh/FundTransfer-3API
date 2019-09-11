package com.bank.app.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bank.app.dto.TransationHistorydto;
import com.bank.app.dto.TransationResponsedto;
import com.bank.app.dto.Transationdto;
import com.bank.app.entity.Account;
import com.bank.app.entity.Transation;

import com.bank.app.exception.AmountInsuffcientException;
import com.bank.app.repository.AccountRepository;
import com.bank.app.repository.TransationRepository;

//1.INPUT FOR OTHER ACCOUNT.1.ACCOUNT NUMBER 2.FROM ACCOUNT 3.AMOUNT
//2.CHECK IF IT IS UR OWN ACCOUNT.ACCOUNTREPO HIT RESONSE ME CUSTID ==UR CUST ID EXP
//ACCOUNT NUMBER JPA METHOD
//3.EVERYTHING IS FINE THEN CHECKFOR -VE AMOUNT
//4.AMOUNT >= UR ACOOUNT BAL
//5.DEDEUCT AMOUT FROM UR ACCOUNT AND ADD IN TO ACCOUNT
//6.INSERT A RECORD IN TRANSACTION TABLE TO AACC FROM ACC AMOUNT


@Service
public class TransationServiceImpl implements TransationService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TransationRepository transationRepository;

	@Override
	public TransationResponsedto fundtransfer(Transationdto transationdto) {
		
		if(transationdto.getAmount()>0)
		{
			Account sender= accountRepository.findByAccountNumber(transationdto.getFromAccount());   
			Account reciever=accountRepository.findByAccountNumber(transationdto.getToAccount());
			if(!(transationdto.getFromAccount()==transationdto.getToAccount()))
			{
				if(sender.getBalance()>=transationdto.getAmount())
				{
					Transation transationCredit=new Transation();
					Transation transationDebit=new Transation();
					double debit=sender.getBalance()-transationdto.getAmount();
					sender.setBalance(debit);
					accountRepository.save(sender);
					double credit=reciever.getBalance()+transationdto.getAmount();
					reciever.setBalance(credit);
					accountRepository.save(reciever);
					
					transationCredit.setAmount(transationdto.getAmount());
					transationCredit.setFromAccount(transationdto.getFromAccount());
					transationCredit.setToAccount(transationdto.getToAccount());
					transationCredit.setTransactionDate(LocalDate.now());
					transationCredit.setTransactionType("CREDIT");
					
					transationRepository.save(transationCredit);
					transationDebit.setAmount(transationdto.getAmount());
					transationDebit.setFromAccount(transationdto.getFromAccount());
					transationDebit.setToAccount(transationdto.getToAccount());
					transationDebit.setTransactionDate(LocalDate.now());
					transationDebit.setTransactionType("DEBIT");
					
					transationRepository.save(transationDebit);
					
					
				}
				else
				{
					throw new AmountInsuffcientException("Amount is not succificient");
				}
				
				
			}
			else
			{
				
				
			}
			
			
			
		}
		
		
		
		
		
		return null;
		
		
			}

	@Override
	public List<TransationHistorydto> viewHistory(int Account) {

    List<TransationHistorydto> responseList=new ArrayList<>();
    Pageable pageable = PageRequest.of(0, 10);
	List<Transation> history=	transationRepository.findByFromAccount(Account,pageable);
	for (Transation transation : history) {
		TransationHistorydto transationHistorydto=new TransationHistorydto();
			/*
			 * transationHistorydto.setAmount(transation.getAmount());
			 * transationHistorydto.setFromAccount(transation.getFromAccount());
			 * transationHistorydto.setToAccount(transation.getToAccount());
			 * transationHistorydto.setTransactionDate(transation.getTransactionDate());
			 * transationHistorydto.setTransactionType(transation.getTransactionType());
			 * transationHistorydto.setTransationId(transation.getTransationId());
			 */
		BeanUtils.copyProperties(transation, transationHistorydto);
		
		responseList.add(transationHistorydto);
		
		
	}
		
		return responseList;
	}


}
