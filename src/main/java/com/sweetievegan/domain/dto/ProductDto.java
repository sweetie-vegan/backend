package com.sweetievegan.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ProductDto {
    private Long productId;
    private String productName;
    private String productDescription;
    private int price;
    private int count;
    private boolean sale;

    @Builder
    public ProductDto(Long productId, String productName, String productDescription, int price, int count, boolean sale) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.count = count;
        this.sale = sale;
    }
}
