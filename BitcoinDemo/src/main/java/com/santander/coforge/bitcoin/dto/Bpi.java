package com.santander.coforge.bitcoin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class Bpi {

	private Currencies USD;
	
	private Currencies GBP;
	
	private Currencies EUR;

	public Currencies getUSD() {
		return USD;
	}

	public void setUSD(Currencies uSD) {
		USD = uSD;
	}

	public Currencies getGBP() {
		return GBP;
	}

	public void setGBP(Currencies gBP) {
		GBP = gBP;
	}

	public Currencies getEUR() {
		return EUR;
	}

	public void setEUR(Currencies eUR) {
		EUR = eUR;
	}

	@Override
	public String toString() {
		return "Bpi [USD=" + USD + ", GBP=" + GBP + ", EUR=" + EUR + "]";
	}

	public Bpi(Currencies uSD, Currencies gBP, Currencies eUR) {
		super();
		USD = uSD;
		GBP = gBP;
		EUR = eUR;
	}

	public Bpi() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
