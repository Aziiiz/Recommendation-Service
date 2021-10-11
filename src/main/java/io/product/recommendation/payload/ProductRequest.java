package io.product.recommendation.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductRequest {
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("product_id")
    private String[] productIds;
    private String[] keywords;
    private String[] shopping;
    private String[] purchased;
}
