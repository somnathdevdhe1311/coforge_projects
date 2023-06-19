package com.santander.coforge.postcode.dto;

public class RequestDto {

	private String name;
	
	private String postcode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Override
	public String toString() {
		return "RequestDto [name=" + name + ", postcode=" + postcode + "]";
	}

	public RequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestDto(String name, String postcode) {
		super();
		this.name = name;
		this.postcode = postcode;
	}
	
	
}
