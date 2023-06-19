package com.santander.coforge.bitcoin.dto;

public class RequestResponseForBitcoin {

	private String currency;
	private String amount;
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "RequestResponseForBitcoin [currency=" + currency + ", amount=" + amount + "]";
	}
	public RequestResponseForBitcoin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestResponseForBitcoin(String currency, String amount) {
		super();
		this.currency = currency;
		this.amount = amount;
	}
	
	
}
