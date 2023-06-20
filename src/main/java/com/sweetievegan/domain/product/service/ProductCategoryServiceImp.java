package com.sweetievegan.domain.product.service;

import com.sweetievegan.domain.product.dto.ProductCategoryDto;
import com.sweetievegan.domain.product.dto.ProductDto;
import com.sweetievegan.domain.product.entity.ProductCategoryEntity;
import com.sweetievegan.domain.product.entity.ProductEntity;
import com.sweetievegan.domain.product.repository.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImp implements ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;
    @Override
    public List<ProductCategoryDto> getAllProductCategories() {
        List<ProductCategoryEntity> productCategoryEntities = productCategoryRepository.findAll();
        List<ProductCategoryDto> productCategoryDtos = new ArrayList<>();
        for(ProductCategoryEntity productCategoryEntity : productCategoryEntities) {
            ProductCategoryDto productCategoryEntityToDto = ProductCategoryDto.builder()
                    .categoryId(productCategoryEntity.getCategoryId())
                    .categoryName(productCategoryEntity.getCategoryName())
                    .build();
            productCategoryDtos.add(productCategoryEntityToDto);
        }
        return productCategoryDtos;
    }
    @Override
    public Long registerProductCategory(ProductCategoryDto productCategoryDto) {
        ProductCategoryEntity productCategoryDtoToEntity = ProductCategoryEntity.builder()
                .categoryId(productCategoryDto.getCategoryId())
                .categoryName(productCategoryDto.getCategoryName())
                .build();
        productCategoryRepository.save(productCategoryDtoToEntity);
        return productCategoryDto.getCategoryId();
    }
    @Override
    public ProductDto updateProductCategoryName(ProductCategoryDto productCategoryDto) {
        return null;
    }

    @Override
    public Long removeProductCategory(Long categoryId) {
        productCategoryRepository.deleteById(categoryId);
        return categoryId;
    }
}
