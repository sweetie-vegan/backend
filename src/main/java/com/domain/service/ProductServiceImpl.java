package com.domain.service;

import com.domain.dto.ProductDto;
import com.domain.entity.ProductEntity;
import com.domain.repository.ProductRepository;
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
//                    .productCategoryId(productEntity.getProductCategory().getCategoryId())
                    .build();
        }
        return productDtos;
    }

    @Override
    public ProductDto findProductByProductId(Long productId) {
        ProductEntity productEntity = productRepository.findProductByProductId(productId);
        ProductDto productEntityToDto = ProductDto.builder()
                .productId(productEntity.getProductId())
                .productName(productEntity.getProductName())
                .productDescription(productEntity.getProductDescription())
                .price(productEntity.getPrice())
                .count(productEntity.getCount())
                .sale(productEntity.isSale())
//                .productCategoryId(productEntity.getProductCategory().getCategoryId())
                .build();
        return productEntityToDto;
    }

    @Override
    public Long registerProduct(ProductDto productDto) {
//        String productCategoryName = productCategoryRepository.findCategoryNameByCategoryId(productDto.getProductCategoryId());
//        ProductCategoryEntity productCategoryEntity = ProductCategoryEntity.builder()
//                .categoryId(productDto.getProductCategoryId())
//                .categoryName(productCategoryName)
//                .build();
        ProductEntity productDtoToEntity = ProductEntity.builder()
                .productId(productDto.getProductId())
                .productName(productDto.getProductName())
                .productDescription(productDto.getProductDescription())
                .price(productDto.getPrice())
                .count(productDto.getCount())
                .sale(productDto.isSale())
//                .productCategory(productCategoryEntity)
                .build();

        productRepository.save(productDtoToEntity);;
        return productDto.getProductId();
    }

    @Override
    public ProductDto updateProductDetail(Long productId, ProductDto productDto) {
        return null;
    }

    @Override
    public int removeProduct(Long productId) {
        return 0;
    }

    @Override
    public List<ProductDto> findProductsBySearchingKeyword(String keyword, int price, boolean sale) {
        return null;
    }
}
