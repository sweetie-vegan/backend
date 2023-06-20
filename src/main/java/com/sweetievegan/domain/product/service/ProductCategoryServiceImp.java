package com.sweetievegan.domain.product.service;

import com.sweetievegan.domain.product.dto.ProductCategoryDto;
import com.sweetievegan.domain.product.dto.ProductDto;
import com.sweetievegan.domain.product.repository.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImp implements ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;
    @Override
    public List<ProductCategoryDto> getAllProductCategories() {
        productCategoryRepository.findAll();
        return null;
    }

    @Override
    public Long registerProductCategory(ProductCategoryDto productCategoryDto) {
        return null;
    }

    @Override
    public ProductDto updateProductCategoryName(ProductCategoryDto productCategoryDto) {
        return null;
    }

    @Override
    public Long removeProductCategory(Long categoryId) {
        return null;
    }
}
