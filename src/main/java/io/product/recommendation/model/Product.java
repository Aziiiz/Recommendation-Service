package io.product.recommendation.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="product")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    @Id
    private long product_id;
    @NonNull
    private String advertiser_id;
    @NonNull
    private String product_code;
    @NonNull
    private String name;
    @NonNull
    private long device_type;
    @NonNull
    private double price;
    @NonNull
    private double discount_price;
}
