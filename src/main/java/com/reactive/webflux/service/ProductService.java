package com.reactive.webflux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactive.webflux.dao.ProductDao;
import com.reactive.webflux.dto.Product;

import reactor.core.publisher.Flux;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	public List<Product> getAllProducts()
	{
		return productDao.getAllProducts();
	}
	
	public Flux<Product> getAllProductsStream()
	{
		return productDao.getAllProductsStream();
	}
}
