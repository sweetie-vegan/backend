package com.sweetievegan.domain.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
//    private Long productId;
    private String productName;
    private String productDescription;
    private int price;
    private int count;
    private boolean sale;
//    private Long productCategoryId;
}
