package com.bank.app.exception;

public class AmountInsuffcientException extends RuntimeException  {

	
	private static final long serialVersionUID = -4141094903896807348L;
	
	public AmountInsuffcientException (String message) {
	super (message);

}
}