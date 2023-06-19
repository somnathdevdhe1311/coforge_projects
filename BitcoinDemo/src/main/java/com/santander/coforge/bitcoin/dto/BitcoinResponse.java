package com.santander.coforge.bitcoin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class BitcoinResponse {

	 private Bpi bpi;

	public Bpi getBpi() {
		return bpi;
	}

	public void setBpi(Bpi bpi) {
		this.bpi = bpi;
	}

	@Override
	public String toString() {
		return "BitcoinResponse [bpi=" + bpi + "]";
	}

	public BitcoinResponse(Bpi bpi) {
		super();
		this.bpi = bpi;
	}

	public BitcoinResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
}
