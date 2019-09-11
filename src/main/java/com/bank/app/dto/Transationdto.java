package com.bank.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Transationdto {
	private int toAccount;
	private int fromAccount;
	private double amount;

}
