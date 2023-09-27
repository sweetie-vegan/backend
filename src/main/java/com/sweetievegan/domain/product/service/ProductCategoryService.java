package com.sweetievegan.domain.product.service;

import com.sweetievegan.domain.product.dto.ProductCategoryRequest;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategoryRequest> getAllProductCategories();
    Long registerProductCategory(ProductCategoryRequest productCategoryRequest);
    ProductCategoryRequest updateProductCategoryName(ProductCategoryRequest productCategoryRequest);
    Long removeProductCategory(Long categoryId);
}
