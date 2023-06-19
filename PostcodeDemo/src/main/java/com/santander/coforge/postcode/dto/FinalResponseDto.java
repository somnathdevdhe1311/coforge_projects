package com.santander.coforge.postcode.dto;

import org.springframework.http.HttpStatus;

public class FinalResponseDto {

	private HttpStatus status;
	
	private String Message;

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public FinalResponseDto(HttpStatus status, String message) {
		super();
		this.status = status;
		Message = message;
	}

	public FinalResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FinalResponseDto [status=" + status + ", Message=" + Message + "]";
	}

	
	
	
	
}
