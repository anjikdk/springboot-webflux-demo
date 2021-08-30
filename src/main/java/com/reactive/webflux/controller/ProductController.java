package com.reactive.webflux.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.webflux.dto.Product;
import com.reactive.webflux.service.ProductService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping
	public List<Product> getAllProducts()
	{
		return productService.getAllProducts();
	}
	
	@GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Product> getAllProductsStream()
	{
		return productService.getAllProductsStream();
	}
}
