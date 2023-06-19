package com.santander.coforge.sample.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.coforge.sample.model.Product;
import com.santander.coforge.sample.repository.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo productRepo;
	

	public Product saveProduct(Product product) {
		
		return productRepo.save(product);
	}


	public List<Product> fetchAllProducts() {
	
		List<Product> allProducts =productRepo.findAll();
		
		List<Product> sortedNonSecureList = allProducts.stream().filter(x->x.getType().equalsIgnoreCase("non secure")).sorted(
				Comparator.comparing(Product::getName)).collect(Collectors.toList());
		
		return sortedNonSecureList;
	}

}
