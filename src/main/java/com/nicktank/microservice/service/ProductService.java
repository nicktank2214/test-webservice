package com.nicktank.microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicktank.microservice.domain.Product;
import com.nicktank.microservice.repository.ProductRepository;




@Service
public class ProductService {

	//inject package repository
	private ProductRepository productRepository;

	
	//constructor
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	
	public Iterable<Product> findAllProducts() {
		return productRepository.findAll();
	}
}
