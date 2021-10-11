package io.product.recommendation.service;

import io.product.recommendation.model.Product;
import io.product.recommendation.payload.ProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public interface RecommendationService {

    ResponseEntity<List<Product>> getListProductsByKeyword(ProductRequest productRequest) throws ResponseStatusException;

    ResponseEntity<List<Product>> getProductByProductId (ProductRequest productRequest) throws ResponseStatusException;

    ResponseEntity<List<Product>> getProductsByShoppingCart(ProductRequest productRequest) throws ResponseStatusException;



}
