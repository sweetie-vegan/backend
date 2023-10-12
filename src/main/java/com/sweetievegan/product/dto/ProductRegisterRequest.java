package com.sweetievegan.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRegisterRequest {
    private String name;
    private String description;
    private int price;
    private int count;
    private boolean isSoldout;
    private Long productCategoryId;
}
