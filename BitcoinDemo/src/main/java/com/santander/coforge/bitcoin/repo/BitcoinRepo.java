package com.santander.coforge.bitcoin.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santander.coforge.bitcoin.model.CurrencyRequest;

public interface BitcoinRepo extends JpaRepository<CurrencyRequest, Integer>{

}
