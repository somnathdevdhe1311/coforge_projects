package com.santander.coforge.postcode.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="postcode_details")
public class PostcodeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private String postcode;
	
	private int quality;
	
	private int eastings;
	
	private int northings;
	
	private String country;
	
	private String nhs_ha;
	
	private double longitude;
	
	private double latitude;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public PostcodeDetails(int id, String name, String postcode, int quality, int eastings, int northings, String country,
			String nhs_ha, double longitude, double latitude) {
		super();
		this.id = id;
		this.name = name;
		this.postcode = postcode;
		this.quality = quality;
		this.eastings = eastings;
		this.northings = northings;
		this.country = country;
		this.nhs_ha = nhs_ha;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public PostcodeDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PostcodeDetails [id=" + id + ", name=" + name + ", postcode=" + postcode + ", quality=" + quality
				+ ", eastings=" + eastings + ", northings=" + northings + ", country=" + country + ", nhs_ha=" + nhs_ha
				+ ", longitude=" + longitude + ", latitude=" + latitude + "]";
	}

	
	
}
