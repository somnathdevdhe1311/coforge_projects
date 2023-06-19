package com.santander.coforge.postcode.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.santander.coforge.postcode.dto.FinalResponseDto;
import com.santander.coforge.postcode.dto.RequestDto;
import com.santander.coforge.postcode.dto.ResponseDto;
import com.santander.coforge.postcode.dto.Result;
import com.santander.coforge.postcode.model.PostcodeDetails;
import com.santander.coforge.postcode.repo.PostcodeRepo;

@Service
public class PostcodeService {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PostcodeRepo postcodeRepo;
	
	
	public FinalResponseDto getPostcodeDetails(String name,String code) {
		
		PostcodeDetails postcodeDetails = postcodeRepo.findByNameAndPostcode(name, code);
		
		if(postcodeDetails== null) {
			 
			postcodeDetails = new PostcodeDetails();
			
			Object objects =restTemplate.getForObject("http://api.postcodes.io/postcodes?q="+code, Object.class);
			
			ResponseDto responseDto = modelMapper.map(objects, ResponseDto.class);
	
			postcodeDetails.setName(name);
			postcodeDetails.setCountry(responseDto.getResult().get(0).getCountry());
			postcodeDetails.setEastings(responseDto.getResult().get(0).getEastings());
			postcodeDetails.setLatitude(responseDto.getResult().get(0).getLatitude());
			postcodeDetails.setLongitude(responseDto.getResult().get(0).getLongitude());
			postcodeDetails.setNhs_ha(responseDto.getResult().get(0).getNhs_ha());
			postcodeDetails.setNorthings(responseDto.getResult().get(0).getNorthings());
			postcodeDetails.setPostcode(responseDto.getResult().get(0).getPostcode());
			postcodeDetails.setQuality(responseDto.getResult().get(0).getQuality());
			
			postcodeRepo.save(postcodeDetails);
		}
		
		String sunset = getSunsetTme(postcodeDetails);
		
		OffsetDateTime sunsetDateTime = OffsetDateTime.parse(sunset, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        LocalDateTime currentDateTime = LocalDateTime.now(ZoneOffset.UTC);
        OffsetDateTime currentOffsetDateTime = OffsetDateTime.of(currentDateTime, ZoneOffset.UTC);

        FinalResponseDto finalResponseDto= new FinalResponseDto();
		if(currentOffsetDateTime.isBefore(sunsetDateTime)){
			
			finalResponseDto.setStatus(HttpStatus.OK);
			finalResponseDto.setMessage("Congratulations "+name+", you are allowed.!!");
		}else {
			finalResponseDto.setStatus(HttpStatus.FORBIDDEN);
			finalResponseDto.setMessage("Sorry "+name+", you are not allowed.!!");
		}
		
		return finalResponseDto;
	}


	private String getSunsetTme(PostcodeDetails postcodeDetails) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String date = LocalDate.now().format(formatter);
		
		Object objects1 =restTemplate.getForObject("https://api.sunrise-sunset.org/json?lat="+postcodeDetails.getLatitude()+"&lng="+postcodeDetails.getLongitude()+"&date="+date+"&formatted="+0, Object.class);
		
		Map<String, Object> responseMap = (Map<String, Object>) objects1;

		Map<String, Object> resultsMap = (Map<String, Object>) responseMap.get("results");

		return (String) resultsMap.get("sunset");
	}


//	public FinalResponseDto getSuniseSunsetDetails(String lat, String lng, String date, String formatted) {
//
//		Object objects =restTemplate.getForObject("https://api.sunrise-sunset.org/json?lat="+lat+"&lng="+lng+"&date="+date+"&formatted="+formatted, Object.class);
//		
//		//SunriseSunsetResponseDto sunriseSunsetResponseDto = modelMapper.map(objects, SunriseSunsetResponseDto.class);
//		FinalResponseDto finalResponseDto= new FinalResponseDto();
//		return null;
//	}


	public ResponseDto checkPostcode(RequestDto requestDto) {
		ResponseDto responseDto = new ResponseDto();
		PostcodeDetails postcodeDetails = postcodeRepo.findByNameAndPostcode(requestDto.getName(), requestDto.getPostcode());
		
		if(postcodeDetails!= null) {
			
			Result result = new Result();
			List<Result> resultList = new ArrayList();
			result.setCountry(postcodeDetails.getCountry());
			result.setEastings(postcodeDetails.getEastings());
			result.setLatitude(postcodeDetails.getLatitude());
			result.setLongitude(postcodeDetails.getLongitude());
			result.setNhs_ha(postcodeDetails.getNhs_ha());
			result.setNorthings(postcodeDetails.getNorthings());
			result.setPostcode(postcodeDetails.getPostcode());
			result.setQuality(postcodeDetails.getQuality());
			resultList.add(result);
			
			responseDto.setStatus(HttpStatus.OK);
			responseDto.setResult(resultList);
		}else {
			responseDto.setStatus(HttpStatus.OK);
			responseDto.setResult(null);
		}
		return responseDto;
	}

}
