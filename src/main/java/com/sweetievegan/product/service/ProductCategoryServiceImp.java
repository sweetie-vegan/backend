package com.sweetievegan.product.service;

import com.sweetievegan.product.dto.ProductCategoryRequest;
import com.sweetievegan.product.entity.ProductCategory;
import com.sweetievegan.product.repository.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImp implements ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;
    @Override
    public List<ProductCategoryRequest> getAllProductCategories() {
        List<ProductCategory> productCategoryEntities = productCategoryRepository.findAll();
        List<ProductCategoryRequest> productCategoryRequests = new ArrayList<>();
        for(ProductCategory productCategory : productCategoryEntities) {
            ProductCategoryRequest productCategoryEntityToDto = ProductCategoryRequest.builder()
                    .categoryId(productCategory.getCategoryId())
                    .categoryName(productCategory.getCategoryName())
                    .build();
            productCategoryRequests.add(productCategoryEntityToDto);
        }
        return productCategoryRequests;
    }
    @Override
    public Long registerProductCategory(ProductCategoryRequest productCategoryRequest) {
        ProductCategory productCategoryDtoToEntity = ProductCategory.builder()
                .categoryId(productCategoryRequest.getCategoryId())
                .categoryName(productCategoryRequest.getCategoryName())
                .build();
        productCategoryRepository.save(productCategoryDtoToEntity);
        return productCategoryRequest.getCategoryId();
    }
    @Override
    public ProductCategoryRequest updateProductCategoryName(ProductCategoryRequest productCategoryRequest) {
        ProductCategory productCategoryToUpdate = productCategoryRepository.findProductCategoryByCategoryId(productCategoryRequest.getCategoryId());
        productCategoryToUpdate.editProductCategory(productCategoryRequest);
        productCategoryRepository.save(productCategoryToUpdate);
        return productCategoryRequest;
    }

    @Override
    public Long removeProductCategory(Long categoryId) {
        productCategoryRepository.deleteById(categoryId);
        return categoryId;
    }
}
