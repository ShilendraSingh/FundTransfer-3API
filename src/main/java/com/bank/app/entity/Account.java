package com.bank.app.entity;

import java.io.Serializable;

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
public class Account implements Serializable {
	
	private static final long serialVersionUID = 6911455408295304184L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
	private int customerId;
	private int accountNumber;
	private double balance;
	private String accountType;
	

}
