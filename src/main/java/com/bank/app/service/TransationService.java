package com.bank.app.service;

import java.util.List;

import com.bank.app.dto.TransationHistorydto;
import com.bank.app.dto.TransationResponsedto;
import com.bank.app.dto.Transationdto;


public interface TransationService {

	public TransationResponsedto  fundtransfer(Transationdto transationdto);
	
	public List<TransationHistorydto> viewHistory (int Account);
	
	

}
