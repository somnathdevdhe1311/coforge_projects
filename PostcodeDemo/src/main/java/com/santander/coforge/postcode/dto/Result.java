package com.santander.coforge.postcode.dto;


public class Result {

	public String postcode;

    public int quality;

    public int eastings;
	
    public int northings;

    public String country;
	
    public String nhs_ha;

    public double longitude;
    
    public double latitude;
   

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public int getEastings() {
		return eastings;
	}

	public void setEastings(int eastings) {
		this.eastings = eastings;
	}

	public int getNorthings() {
		return northings;
	}

	public void setNorthings(int northings) {
		this.northings = northings;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNhs_ha() {
		return nhs_ha;
	}

	public void setNhs_ha(String nhs_ha) {
		this.nhs_ha = nhs_ha;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "Result [postcode=" + postcode + ", quality=" + quality + ", eastings=" + eastings + ", northings="
				+ northings + ", country=" + country + ", nhs_ha=" + nhs_ha + ", longitude=" + longitude + ", latitude="
				+ latitude + "]";
	}

	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Result(String postcode, int quality, int eastings, int northings, String country, String nhs_ha,
			double longitude, double latitude, String sunrise, String sunset) {
		super();
		this.postcode = postcode;
		this.quality = quality;
		this.eastings = eastings;
		this.northings = northings;
		this.country = country;
		this.nhs_ha = nhs_ha;
		this.longitude = longitude;
		this.latitude = latitude;
		
	}

	
}
