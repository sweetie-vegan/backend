package com.sweetievegan.domain.product.service;

import com.sweetievegan.domain.product.dto.ProductDto;
import com.sweetievegan.domain.product.entity.ProductCategoryEntity;
import com.sweetievegan.domain.product.entity.ProductEntity;
import com.sweetievegan.domain.product.repository.ProductCategoryRepository;
import com.sweetievegan.domain.product.repository.ProductRepository;
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
    private final ProductCategoryRepository productCategoryRepository;

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
                .productCategoryId(productEntity.getProductCategory().getCategoryId())
                .build();
        return productEntityToDto;
    }

    @Override
    public Long registerProduct(ProductDto productDto) {
        String productCategoryName = productCategoryRepository.findCategoryNameByCategoryId(productDto.getProductCategoryId());
        ProductCategoryEntity productCategoryEntity = ProductCategoryEntity.builder()
                .categoryId(productDto.getProductCategoryId())
                .categoryName(productCategoryName)
                .build();
        ProductEntity productDtoToEntity = ProductEntity.builder()
                .productId(productDto.getProductId())
                .productName(productDto.getProductName())
                .productDescription(productDto.getProductDescription())
                .price(productDto.getPrice())
                .count(productDto.getCount())
                .sale(productDto.isSale())
                .productCategory(productCategoryEntity)
                .build();

        productRepository.save(productDtoToEntity);;
        return productDto.getProductId();
    }

    @Override
    public ProductDto updateProductDetail(Long productId, ProductDto productDto) {
        ProductEntity productEntityToUpdate = productRepository.findProductByProductId(productId);
        productEntityToUpdate.editProductDetail(productDto.getProductName(), productDto.getProductDescription(), productDto.getPrice(), productDto.getCount());
        productRepository.save(productEntityToUpdate);
        return productDto;
    }

    @Override
    public Long removeProduct(Long productId) {
        productRepository.deleteById(productId);
        return productId;
    }

    @Override
    public List<ProductDto> findProductsBySearchingKeyword(String keyword, int price, boolean sale) {
        return null;
    }
}
