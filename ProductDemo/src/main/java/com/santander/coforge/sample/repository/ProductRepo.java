package com.santander.coforge.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santander.coforge.sample.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
