package com.sweetievegan.domain.product.service;

import com.sweetievegan.domain.product.dto.ProductRegisterRequest;
import com.sweetievegan.domain.product.dto.ProductResponse;
import com.sweetievegan.domain.product.entity.ProductCategory;
import com.sweetievegan.domain.product.entity.Product;
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
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> productEntities = productRepository.findAll();
        List<ProductResponse> productDtos = new ArrayList<>();
        for(Product product : productEntities) {
            ProductResponse productEntityToDto = ProductResponse.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .price(product.getPrice())
                    .count(product.getCount())
                    .isSoldout(product.isSoldout())
//                    .productCategoryId(productEntity.getProductCategory().getCategoryId().longValue())
                    .build();
            productDtos.add(productEntityToDto);
        }
        return productDtos;
    }

    @Override
    public ProductResponse findProductByProductId(Long productId) {
        Product product = productRepository.findProductByProductId(productId);
        ProductResponse productEntityToDto = ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .count(product.getCount())
                .isSoldout(product.isSoldout())
                .productCategoryId(product.getProductCategory().getCategoryId())
                .build();
        return productEntityToDto;
    }

    @Override
    public Long registerProduct(ProductRegisterRequest productRegisterRequest) {
        ProductCategory productCategory = productCategoryRepository.findProductCategoryByCategoryId(productRegisterRequest.getProductCategoryId());
        Product productDtoToEntity = Product.builder()
                .name(productRegisterRequest.getName())
                .description(productRegisterRequest.getDescription())
                .price(productRegisterRequest.getPrice())
                .count(productRegisterRequest.getCount())
                .isSoldout(productRegisterRequest.isSoldout())
                .productCategory(productCategory)
                .build();
        productRepository.save(productDtoToEntity);
        return productRepository.save(productDtoToEntity).getId();
    }

    @Override
    public ProductRegisterRequest updateProductDetail(Long productId, ProductRegisterRequest productRegisterRequest) {
        ProductCategory productCategory = productCategoryRepository.findProductCategoryByCategoryId(productRegisterRequest.getProductCategoryId());
        Product productToUpdate = productRepository.findProductByProductId(productId);
        productToUpdate.editProductDetail(productRegisterRequest.getName(), productRegisterRequest.getDescription(), productRegisterRequest.getPrice(), productRegisterRequest.getCount(), productCategory);
        return productRegisterRequest;
    }

    @Override
    public Long removeProduct(Long productId) {
        productRepository.deleteById(productId);
        return productId;
    }

    @Override
    public List<ProductRegisterRequest> findProductsBySearchingKeyword(String keyword, int price, boolean sale) {
        return null;
    }
}
