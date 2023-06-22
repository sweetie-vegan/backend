package com.sweetievegan.domain.product.service;

import com.sweetievegan.domain.product.dto.ProductRequestDto;
import com.sweetievegan.domain.product.dto.ProductResponseDto;
import com.sweetievegan.domain.product.entity.ProductCategoryEntity;
import com.sweetievegan.domain.product.entity.ProductCompanyEntity;
import com.sweetievegan.domain.product.entity.ProductEntity;
import com.sweetievegan.domain.product.repository.ProductCategoryRepository;
import com.sweetievegan.domain.product.repository.ProductCompanyRepository;
import com.sweetievegan.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductCompanyRepository productCompanyRepository;

    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
        List<ProductResponseDto> productDtos = new ArrayList<>();
        for(ProductEntity productEntity : productEntities) {
            ProductResponseDto productEntityToDto = ProductResponseDto.builder()
                    .productId(productEntity.getProductId())
                    .productName(productEntity.getProductName())
                    .productDescription(productEntity.getProductDescription())
                    .price(productEntity.getPrice())
                    .count(productEntity.getCount())
                    .sale(productEntity.isSellStatus())
                    .productCategoryId(productEntity.getProductCategory().getCategoryId())
                    .build();
            productDtos.add(productEntityToDto);
        }
        return productDtos;
    }

    @Override
    public ProductResponseDto findProductByProductId(Long productId) {
        ProductEntity productEntity = productRepository.findProductByProductId(productId);
        ProductResponseDto productEntityToDto = ProductResponseDto.builder()
                .productId(productEntity.getProductId())
                .productName(productEntity.getProductName())
                .productDescription(productEntity.getProductDescription())
                .price(productEntity.getPrice())
                .count(productEntity.getCount())
                .sale(productEntity.isSellStatus())
                .productCategoryId(productEntity.getProductCategory().getCategoryId())
                .build();
        return productEntityToDto;
    }

    @Override
    public Long registerProduct(ProductRequestDto productRequestDto) {
        ProductCategoryEntity productCategoryEntity = productCategoryRepository.findProductCategoryEntityByCategoryId(productRequestDto.getProductCategoryId());
        ProductCompanyEntity productCompanyEntity = productCompanyRepository.findCompanyByCompanyName(productRequestDto.getCompanyName());
        ProductEntity productDtoToEntity = ProductEntity.builder()
                .productName(productRequestDto.getProductName())
                .productDescription(productRequestDto.getProductDescription())
                .price(productRequestDto.getPrice())
                .count(productRequestDto.getCount())
                .productCompany(productCompanyEntity)
                .productCategory(productCategoryEntity)
                .build();
        productRepository.save(productDtoToEntity);
        return productRepository.save(productDtoToEntity).getProductId();
    }

    @Override
    public ProductRequestDto updateProductDetail(Long productId, ProductRequestDto productRequestDto) {
        ProductCategoryEntity productCategoryEntity = productCategoryRepository.findProductCategoryEntityByCategoryId(productRequestDto.getProductCategoryId());
        ProductCompanyEntity productCompanyEntity = productCompanyRepository.findCompanyByCompanyName(productRequestDto.getCompanyName());
        ProductEntity productEntityToUpdate = productRepository.findProductByProductId(productId);
        productEntityToUpdate.editProductDetail(productRequestDto.getProductName(),
                productRequestDto.getProductDescription(),
                productRequestDto.getPrice(),
                productRequestDto.getCount(),
                productCategoryEntity,
                productCompanyEntity
        );
        return productRequestDto;
    }

    @Override
    public Long removeProduct(Long productId) {
        productRepository.deleteById(productId);
        return productId;
    }

    @Override
    public List<ProductRequestDto> findProductsBySearchingKeyword(String keyword, int price, boolean sale) {
        return null;
    }
}
