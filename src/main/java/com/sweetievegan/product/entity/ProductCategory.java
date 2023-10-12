package com.sweetievegan.product.entity;

import com.sweetievegan.product.dto.ProductCategoryRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_categories")
public class ProductCategory {
    @Id
    private Long categoryId;
    private String categoryName;

    public void editProductCategory(ProductCategoryRequest productCategoryRequest) {
        this.categoryId = productCategoryRequest.getCategoryId();
        this.categoryName = productCategoryRequest.getCategoryName();
    }
}

