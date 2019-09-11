package com.bank.app.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Transation implements Serializable{
	

	private static final long serialVersionUID = 3963411852888387174L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long transationId;
	private int toAccount;
	private int fromAccount;
	private double amount;
	private LocalDate transactionDate;
	private String transactionType;

}
