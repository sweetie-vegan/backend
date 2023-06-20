package com.sweetievegan.domain.product.entity;

import com.sweetievegan.domain.product.dto.ProductCategoryDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "product_categories")
public class ProductCategoryEntity {
    @Id
    private Long categoryId;
    private String categoryName;

    @Builder
    public ProductCategoryEntity(Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public void updateProductCategory(ProductCategoryDto productCategoryDto) {
        this.categoryId = productCategoryDto.getCategoryId();
        this.categoryName = productCategoryDto.getCategoryName();
    }
}

