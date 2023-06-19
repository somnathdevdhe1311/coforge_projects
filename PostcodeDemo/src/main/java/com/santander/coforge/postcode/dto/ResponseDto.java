package com.santander.coforge.postcode.dto;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDto {

	public HttpStatus status;
	
	public List<Result> result;

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public List<Result> getResult() {
		return result;
	}

	public void setResult(List<Result> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ResponseDto [status=" + status + ", result=" + result + "]";
	}

	public ResponseDto(HttpStatus status, List<Result> result) {
		super();
		this.status = status;
		this.result = result;
	}

	public ResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

		
	
}
