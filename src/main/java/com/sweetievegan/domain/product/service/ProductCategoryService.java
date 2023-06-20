package com.sweetievegan.domain.product.service;

import com.sweetievegan.domain.product.dto.ProductCategoryDto;
import com.sweetievegan.domain.product.dto.ProductDto;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategoryDto> getAllProductCategories();
    Long registerProductCategory(ProductCategoryDto productCategoryDto);
    ProductDto updateProductCategoryName(ProductCategoryDto productCategoryDto);
    Long removeProductCategory(Long categoryId);
}
