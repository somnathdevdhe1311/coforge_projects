package com.santander.coforge.bitcoin.customExceptions;

public class CurrencyNotFoundException extends RuntimeException {
	
	private String error;
	
	private String message;

	public CurrencyNotFoundException(String error, String message) {
		super();
		this.error = error;
		this.message = message;
	}

	public CurrencyNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CurrencyNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CurrencyNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CurrencyNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CurrencyNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}


}
