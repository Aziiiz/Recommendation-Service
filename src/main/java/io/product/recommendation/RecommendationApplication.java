package io.product.recommendation;


import io.product.recommendation.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableSwagger2
public class RecommendationApplication {

	@Autowired
	public ProductService productService;

	public static void main(String[] args) {

		SpringApplication.run(RecommendationApplication.class, args);

	}

	@PostConstruct
	void init(){
		productService.saveProductCSV("./product.csv");
	}



}
