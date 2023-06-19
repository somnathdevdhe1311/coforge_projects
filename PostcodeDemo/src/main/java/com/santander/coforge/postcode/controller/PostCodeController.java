package com.santander.coforge.postcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.santander.coforge.postcode.dto.FinalResponseDto;
import com.santander.coforge.postcode.dto.RequestDto;
import com.santander.coforge.postcode.dto.ResponseDto;
import com.santander.coforge.postcode.service.PostcodeService;

@RestController
@RequestMapping("/postCodes")
public class PostCodeController {

	
	@Autowired
	private PostcodeService postcodeService;
	

	@GetMapping("/")
	public FinalResponseDto savePostcodeDetails(@RequestParam String name, @RequestParam String code){
		
		FinalResponseDto responseDto = postcodeService.getPostcodeDetails(name,code);

		return responseDto;
	}
	
	@PostMapping("/getDetails")
	public ResponseDto getPostcodeDetails(@RequestBody RequestDto requestDto) {
		
		return postcodeService.checkPostcode(requestDto);
	}
	
//	@GetMapping("/surrise-sunset")
//	public FinalResponseDto getsunRiseSetDetails(@RequestParam String lat, @RequestParam String lng,@RequestParam String date,@RequestParam String formatted){
//		
//		FinalResponseDto finalResponseDto = postcodeService.getSuniseSunsetDetails(lat,lng,date,formatted);
//
//		return finalResponseDto;
//	}
	
	
	
}
