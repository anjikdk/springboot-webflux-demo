package com.reactive.webflux.dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.reactive.webflux.dto.Product;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Component
@Slf4j
public class ProductDao {
	
	private static void sleepExecution(int i){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	public List<Product> getAllProducts()
	{
		return IntStream.rangeClosed(1, 10)
				.peek(ProductDao::sleepExecution)
				.peek(i -> log.info("processing count : " + i))
				.mapToObj(i -> new Product(i, "Product "+i))
				.collect(Collectors.toList());
	}
	
	public Flux<Product> getAllProductsStream()
	{
		return Flux.range(1, 10)
				.delayElements(Duration.ofSeconds(1))
				.doOnNext(i -> System.out.println("processing count in stream flow : " +i))
				.map(i -> new Product(i, "Product "+i));
	}
}
