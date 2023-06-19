package com.santander.coforge.bitcoin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


public class Currencies {

	private String code;
	private String symbol;
	private float rate;
	private String description;
	private float rate_float;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getRate_float() {
		return rate_float;
	}
	public void setRate_float(float rate_float) {
		this.rate_float = rate_float;
	}
	public Currencies() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Currencies(String code, String symbol, float rate, String description, float rate_float) {
		super();
		this.code = code;
		this.symbol = symbol;
		this.rate = rate;
		this.description = description;
		this.rate_float = rate_float;
	}
	@Override
	public String toString() {
		return "Currencies [code=" + code + ", symbol=" + symbol + ", rate=" + rate + ", description=" + description
				+ ", rate_float=" + rate_float + "]";
	}
	
	
    
}
