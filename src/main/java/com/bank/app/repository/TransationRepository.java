package com.bank.app.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.app.entity.Transation;

@Repository
public interface TransationRepository extends JpaRepository<Transation, Integer>  {
	
	public List<Transation> findByFromAccount(int Account,Pageable pageable);

	
	
	
}
