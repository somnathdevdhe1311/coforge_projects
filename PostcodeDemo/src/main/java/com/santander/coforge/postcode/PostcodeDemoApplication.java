package com.santander.coforge.postcode;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PostcodeDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostcodeDemoApplication.class, args);
	}
	
	@Bean
	public RestTemplate getTemplate() {
		
		return new RestTemplate();
	}
	
	@Bean
	public ModelMapper modelMapper() {
		
		return new ModelMapper();
	}

}
