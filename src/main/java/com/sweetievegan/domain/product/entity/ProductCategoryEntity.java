package com.sweetievegan.domain.product.entity;

import com.sweetievegan.domain.product.dto.ProductCategoryDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "product_categories")
public class ProductCategoryEntity {
    @Id
    private Long categoryId;
    private String categoryName;

    public void editProductCategory(ProductCategoryDto productCategoryDto) {
        this.categoryId = productCategoryDto.getCategoryId();
        this.categoryName = productCategoryDto.getCategoryName();
    }
}

