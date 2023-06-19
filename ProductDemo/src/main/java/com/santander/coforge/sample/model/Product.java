package com.santander.coforge.sample.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private Integer productID;
	
	private String name;
	
	private String description;
	
	private String type;

	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", name=" + name + ", description=" + description + ", type=" + type
				+ "]";
	}

	public Product(Integer productID, String name, String description, String type) {
		super();
		this.productID = productID;
		this.name = name;
		this.description = description;
		this.type = type;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
