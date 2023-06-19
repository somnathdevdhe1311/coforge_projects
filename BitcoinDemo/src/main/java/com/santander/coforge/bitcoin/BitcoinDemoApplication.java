package com.santander.coforge.bitcoin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BitcoinDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitcoinDemoApplication.class, args);
	}

}
