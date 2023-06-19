package com.santander.coforge.bitcoin.globalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.santander.coforge.bitcoin.customExceptions.CurrencyNotFoundException;

@ControllerAdvice
public class CurrencyExchangeController {
	
	@ExceptionHandler(value=CurrencyNotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> handleException() {
		
		return new ResponseEntity<String>("Currency not found in db.", HttpStatus.NOT_FOUND);
	}

}
