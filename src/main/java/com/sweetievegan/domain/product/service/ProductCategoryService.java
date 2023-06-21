package com.sweetievegan.domain.product.service;

import com.sweetievegan.domain.product.dto.ProductCategoryDto;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategoryDto> getAllProductCategories();
    Long registerProductCategory(ProductCategoryDto productCategoryDto);
    ProductCategoryDto updateProductCategoryName(ProductCategoryDto productCategoryDto);
    Long removeProductCategory(Long categoryId);
}
