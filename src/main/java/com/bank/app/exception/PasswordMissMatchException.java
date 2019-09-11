package com.bank.app.exception;

public class PasswordMissMatchException extends RuntimeException  {


	private static final long serialVersionUID = -6588259966534859295L;

	public PasswordMissMatchException(String message) {
		super(message);
	}
	
}
