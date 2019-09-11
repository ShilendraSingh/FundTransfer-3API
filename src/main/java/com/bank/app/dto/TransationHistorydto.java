package com.bank.app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransationHistorydto {
	
	private Long transationId;
	private int toAccount;
	private int fromAccount;
	private double amount;
	private LocalDate transactionDate;
	private String transactionType;

}
