package io.product.recommendation.controller;


import io.product.recommendation.model.Product;
import io.product.recommendation.payload.ProductRequest;
import io.product.recommendation.service.RecommendationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@Api(tags = "Recommendation - REST APIs")
@RequestMapping("/api/recommendation")
public class RecomendationController {

    @Autowired
    RecommendationService recommendationService;

    @PostMapping("/keyword")
    private ResponseEntity<List<Product>> getProductsByKeyword(@RequestBody ProductRequest productRequest) throws ResponseStatusException {
        return recommendationService.getListProductsByKeyword(productRequest);
    }
    @PostMapping("/product-id")
    private ResponseEntity<List<Product>> getProductsByProductId(@RequestBody ProductRequest productRequest) throws ResponseStatusException {
        return recommendationService.getProductByProductId(productRequest);
    }
    @PostMapping("/shopping-cart")
    private ResponseEntity<List<Product>> getPRoductsByShoppingCart(@RequestBody ProductRequest productRequest) throws ResponseStatusException {
        return recommendationService.getProductsByShoppingCart(productRequest);
    }
}
