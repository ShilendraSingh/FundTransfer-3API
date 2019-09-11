package com.bank.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.app.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {


	Account findByAccountNumber(int accountNumber);
	
	
}
