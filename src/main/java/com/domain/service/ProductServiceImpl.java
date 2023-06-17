package com.domain.service;

import com.domain.dto.ProductDto;
import com.domain.entity.ProductEntity;
import com.domain.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductDto> getAllProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for(ProductEntity productEntity : productEntities) {
            ProductDto productEntityToDto = ProductDto.builder()
                    .productId(productEntity.getProductId())
                    .productName(productEntity.getProductName())
                    .productDescription(productEntity.getProductDescription())
                    .price(productEntity.getPrice())
                    .count(productEntity.getCount())
                    .sale(productEntity.isSale())
                    .productCategoryId(productEntity.getProductCategory().getCategoryId())
                    .productCategoryName(productEntity.getProductCategory().getName())
                    .build();
        }
        return productDtos;
    }

    @Override
    public ProductDto findProductByProductId(int productId) {
        return null;
    }

    @Override
    public int registerProduct(ProductDto productDto) {
        return 0;
    }

    @Override
    public ProductDto updateProductDetail(int productId, ProductDto productDto) {
        return null;
    }

    @Override
    public int removeProduct(int productId) {
        return 0;
    }

    @Override
    public List<ProductDto> findProductsBySearchingKeyword(String keyword, int price, boolean sale) {
        return null;
    }
}
