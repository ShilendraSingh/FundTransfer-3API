package com.bank.app.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.app.dto.CustomerRequestdto;
import com.bank.app.dto.CustomerResponsedto;
import com.bank.app.entity.Account;
import com.bank.app.entity.Customer;
import com.bank.app.exception.PasswordMissMatchException;
import com.bank.app.repository.AccountRepository;
import com.bank.app.repository.CustomerRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public CustomerResponsedto register(CustomerRequestdto customerRequestdto) {

		Customer customer = new Customer();
		Account account=new Account();
		CustomerResponsedto customerResponsedto=new CustomerResponsedto();

		Random random =new Random();

		if (customerRequestdto.getPassword().equals(customerRequestdto.getConfirmPassword())) {
			customer.setAge(customerRequestdto.getAge());
			customer.setGender(customerRequestdto.getGender());
			customer.setMobileNumber(customerRequestdto.getMobileNumber());
			customer.setName(customerRequestdto.getName());
			customer.setPassword(customerRequestdto.getPassword());
			Customer savedCustomer=customerRepository.save(customer);
			account.setAccountNumber(random.nextInt(1000000));
			account.setAccountType("SBA");
			account.setBalance(10000);
			account.setCustomerId(savedCustomer.getCustomerId());
			Account savedAcount=accountRepository.save(account);
			customerResponsedto.setMessgae("anything with account"+savedAcount.getAccountNumber());
			customerResponsedto.setStatusCode(201);
			

		} else {
			
			throw new PasswordMissMatchException("Entered password and Confrim password is not same");
		}

		return customerResponsedto;
	}

}

