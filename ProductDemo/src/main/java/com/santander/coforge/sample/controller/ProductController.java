package com.santander.coforge.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santander.coforge.sample.model.Product;
import com.santander.coforge.sample.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	
	@Autowired
	ProductService productService;

	
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product){
		
		Product savedProduct = productService.saveProduct(product);
		return savedProduct;
		//return new ResponseEntity<Product>(savedProduct, HttpStatus.CREATED);
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<List<Product>> fetchAllProducts(){
		
		List<Product> savedProduct = productService.fetchAllProducts();
		
		return new ResponseEntity<List<Product>>(savedProduct, HttpStatus.OK);
	}
}
