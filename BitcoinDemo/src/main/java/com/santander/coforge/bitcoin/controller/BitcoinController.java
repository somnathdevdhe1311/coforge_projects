package com.santander.coforge.bitcoin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santander.coforge.bitcoin.customExceptions.CurrencyNotFoundException;
import com.santander.coforge.bitcoin.dto.BitcoinResponse;
import com.santander.coforge.bitcoin.dto.Bpi;
import com.santander.coforge.bitcoin.dto.Currencies;
import com.santander.coforge.bitcoin.dto.RequestResponseForBitcoin;
import com.santander.coforge.bitcoin.model.CurrencyRequest;
import com.santander.coforge.bitcoin.service.BitcoinService;

@RestController
@RequestMapping("/currency")
public class BitcoinController {

	@Autowired
	private BitcoinService bitcoinService;
	
	@GetMapping("/getAllCurrencies")
	public BitcoinResponse getAllCurrencies() {
		
		BitcoinResponse bitcoinResponse = new BitcoinResponse();
		
		Bpi bpi = new Bpi();
		
		List<CurrencyRequest> currencyRequest = bitcoinService.getAllCurrencies();
		
		for (int i = 0; i < currencyRequest.size(); i++) {
			
			Currencies currencies = new Currencies();
			
			currencies.setCode(currencyRequest.get(i).getCode());
			currencies.setDescription(currencyRequest.get(i).getDescription());
			currencies.setRate(currencyRequest.get(i).getRate());
			currencies.setRate_float(currencyRequest.get(i).getRate_float());
			currencies.setSymbol(currencyRequest.get(i).getSymbol());
			
			if(currencyRequest.get(i).getCode().equalsIgnoreCase("USD")) {
				bpi.setUSD(currencies);
			}else if(currencyRequest.get(i).getCode().equalsIgnoreCase("GBP")) {
				bpi.setGBP(currencies);
			}else if(currencyRequest.get(i).getCode().equalsIgnoreCase("EUR")) {
				bpi.setEUR(currencies);
			}
			
			bitcoinResponse.setBpi(bpi);
		}
		return bitcoinResponse;
	}
	
	@PostMapping("/save")
	public CurrencyRequest saveCurrency(@RequestBody CurrencyRequest currencyRequest) {
		
		CurrencyRequest savedCurrencyRequest = 	bitcoinService.saveCurrency(currencyRequest);
		 if(!savedCurrencyRequest.getCode().equalsIgnoreCase("IND")) {
			 
			 throw new CurrencyNotFoundException("Currency not found in db"); 
		 }
		
		return savedCurrencyRequest;
	}
	
	@GetMapping("/calculateBitcoins")
	 public RequestResponseForBitcoin calculateBitcoins(@RequestBody RequestResponseForBitcoin requestResponseForBitcoin){
			
			RequestResponseForBitcoin response = bitcoinService.calculateBitcoins(requestResponseForBitcoin);

			return response;
	   }
		

}
