package com.sweetievegan.product.service;

import com.sweetievegan.product.dto.request.ProductCategoryRequest;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategoryRequest> getAllProductCategories();
    Long registerProductCategory(ProductCategoryRequest productCategoryRequest);
    ProductCategoryRequest updateProductCategoryName(ProductCategoryRequest productCategoryRequest);
    Long removeProductCategory(Long categoryId);
}
