package io.product.recommendation.dao;

import io.product.recommendation.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.List;


@Repository
public interface ProductDao extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM  product p WHERE lower(p.name) REGEXP lower(:term)", nativeQuery = true)
    List<Product> getProductByLikeQuery(@Param("term") String keywords);

    @Query(value = "SELECT * from product as pr WHERE pr.device_type in (" +
            "SELECT device_type from product p WHERE product_id IN :term GROUP BY device_type) ORDER BY  pr.product_id DESC", nativeQuery = true)
    List<Product> getProductsByProductId(@Param("term") Collection<String> ids);

    @Query(value = "SELECT * from product as pr WHERE pr.device_type in (" +
            "SELECT DISTINCT device_type from product p WHERE product_id in :term)", nativeQuery = true)
    List<Product> getProductByShoppingCart(@Param("term") Collection<String> ids);
}

