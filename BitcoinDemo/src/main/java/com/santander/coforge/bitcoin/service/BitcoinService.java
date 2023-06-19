package com.santander.coforge.bitcoin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.coforge.bitcoin.client.FeignClientExample;
import com.santander.coforge.bitcoin.dto.BitcoinResponse;
import com.santander.coforge.bitcoin.dto.Bpi;
import com.santander.coforge.bitcoin.dto.Currencies;
import com.santander.coforge.bitcoin.dto.RequestResponseForBitcoin;
import com.santander.coforge.bitcoin.model.CurrencyRequest;
import com.santander.coforge.bitcoin.repo.BitcoinRepo;

@Service	
public class BitcoinService {
	
	@Autowired
	BitcoinRepo bitcoinRepo;
	
	@Autowired
	FeignClientExample feignClientExample;

	public List<CurrencyRequest> getAllCurrencies() {
		
		return bitcoinRepo.findAll();
	}

	public CurrencyRequest saveCurrency(CurrencyRequest currencyRequest) {
		
		
		return bitcoinRepo.save(currencyRequest);
	}

	public RequestResponseForBitcoin calculateBitcoins(RequestResponseForBitcoin request) {
		
		RequestResponseForBitcoin result = new RequestResponseForBitcoin();
		BitcoinResponse bitcoinResponse = feignClientExample.getAllCurrencies();
		
		Bpi bpi = bitcoinResponse.getBpi();
		//Currencies currencies[] = bpi.;
		
		float bitcoins = 0;
		if(request.getCurrency().equalsIgnoreCase("USD")) {
			bitcoins = calculateAmount(request, bitcoinResponse);
		}else if(request.getCurrency().equalsIgnoreCase("GBP")) {
			bitcoins = calculateAmount(request, bitcoinResponse);
		}else if(request.getCurrency().equalsIgnoreCase("EUR")) {
			bitcoins = calculateAmount(request, bitcoinResponse);
		}
		result.setAmount(String.valueOf(bitcoins));
		result.setCurrency(request.getCurrency());
		
		return result;
	}

	private float calculateAmount(RequestResponseForBitcoin request, BitcoinResponse bitcoinResponse) {
		float bitcoins;
		float amount = Float.valueOf(request.getAmount());
		
		float rate = bitcoinResponse.getBpi().getUSD().getRate();
		
		 bitcoins = amount/rate;
		return bitcoins;
	}

}
