package com.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductWithCategoryDto {
    private Long productId;
    private String productName;
    private String productDescription;
    private int price;
    private int count;
    private boolean sale;
    private String categoryId;
}
