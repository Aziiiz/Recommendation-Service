package io.product.recommendation.service.impl;

import io.product.recommendation.dao.ProductDao;
import io.product.recommendation.model.Product;
import io.product.recommendation.payload.ProductRequest;
import io.product.recommendation.service.RecommendationService;
import io.product.recommendation.util.ExceptionToStatusCode;
import io.product.recommendation.util.Spelling;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private static final Logger logger = LoggerFactory.getLogger(RecommendationServiceImpl.class);

    @Autowired
    ProductDao productDao;

    @Override
    public ResponseEntity<List<Product>> getListProductsByKeyword(ProductRequest productRequest) throws ResponseStatusException  {
        try {
            if(productRequest.getUserId() != null && productRequest.getUserId() != "") {
                StringBuilder str = new StringBuilder();
                for (String keyword : productRequest.getKeywords()) {
                    str.append(keyword).append("|");
                }
                str.setLength(str.length() - 1);

                return ResponseEntity.ok(productDao.getProductByLikeQuery(str.toString()));
            }else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "user id must be provided");
            }
        }catch (Exception e) {
            logger.error(e.getMessage());
            throw new ResponseStatusException(ExceptionToStatusCode.convert(e), e.getMessage(), e.getCause());
        }
    }

    @Override
    public ResponseEntity<List<Product>> getProductByProductId(ProductRequest productRequest) throws ResponseStatusException {
        try {
            if(productRequest.getUserId() != null && productRequest.getUserId() != "") {
                List list = Arrays.asList(productRequest.getProductIds());
                return ResponseEntity.ok(productDao.getProductsByProductId(list));
            }else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "user id must be provided");
            }
        }catch (Exception e) {
            logger.error(e.getMessage());
            throw new ResponseStatusException(ExceptionToStatusCode.convert(e), e.getMessage(), e.getCause());
        }
    }

    @Override
    public ResponseEntity<List<Product>> getProductsByShoppingCart(ProductRequest productRequest) throws ResponseStatusException {
        try {
            if(productRequest.getUserId() != null && productRequest.getUserId() != "") {
                List list = Arrays.asList(productRequest.getProductIds());
                return ResponseEntity.ok(productDao.getProductByShoppingCart(list));
            }else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "user id must be provided");

            }
        }catch (Exception e) {
            logger.error(e.getMessage());
            throw new ResponseStatusException(ExceptionToStatusCode.convert(e), e.getMessage(), e.getCause());
        }

    }



}
