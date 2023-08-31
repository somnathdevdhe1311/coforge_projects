package com.santander.coforge.bitcoin.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.santander.coforge.bitcoin.client.FeignClientExample;
import com.santander.coforge.bitcoin.dto.BitcoinResponse;
import com.santander.coforge.bitcoin.dto.Bpi;
import com.santander.coforge.bitcoin.dto.RequestResponseForBitcoin;
import com.santander.coforge.bitcoin.model.CurrencyRequest;
import com.santander.coforge.bitcoin.repo.BitcoinRepo;

@Service	
public class BitcoinService {
	
	@Autowired
	BitcoinRepo bitcoinRepo;
	
	@Autowired
	FeignClientExample feignClientExample;
	
	Logger logger = LoggerFactory.getLogger(BitcoinService.class);

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

	@CachePut(key="#currencyRequest.id", value="currency")
	public CurrencyRequest updateCurrency(CurrencyRequest currencyRequest) {
		
		CurrencyRequest request = bitcoinRepo.findById(currencyRequest.getId()).orElse(null);
		request.setCode(currencyRequest.getCode());
		request.setDescription(currencyRequest.getDescription());
		request.setRate(currencyRequest.getRate());
		request.setRate_float(currencyRequest.getRate_float());
		request.setSymbol(currencyRequest.getSymbol());
		
		logger.info("updateCurrency method called and data fetch from db.");
		return bitcoinRepo.save(request);
	}

	@CacheEvict(value="currency", allEntries = true)
	public String deleteCurrency(int id) {
		
		 bitcoinRepo.deleteById(id);
		 logger.info("deleteCurrency method called and data fetch from db.");
		 return "Currency removed !! " + id;
	}

	@Cacheable(value="currency", key="#id") 
	//unless ="#result.salary < 50000"  cache will not store the data of having more than 50000 salary
	public CurrencyRequest getCurrencyById(int id) {
	
		logger.info("getCurrencyById method called and data fetch from db.");
		return bitcoinRepo.findById(id).orElse(null);
	}

}
