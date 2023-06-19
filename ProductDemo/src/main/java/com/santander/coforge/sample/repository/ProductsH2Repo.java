package com.santander.coforge.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santander.coforge.sample.model.Product;

public interface ProductsH2Repo  extends JpaRepository<Product, Integer>{

}
