package com.sweetievegan.product.service;

import com.sweetievegan.product.dto.request.ProductRegisterRequest;
import com.sweetievegan.product.dto.response.ProductResponse;
import com.sweetievegan.product.entity.ProductCategory;
import com.sweetievegan.product.entity.Product;
import com.sweetievegan.product.repository.ProductCategoryRepository;
import com.sweetievegan.product.repository.ProductRepository;
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
                    .productCategoryId(product.getProductCategory().getCategoryId())
                    .ingredient(product.getIngredient())
                    .recipe(product.getRecipe())
                    .build();
            productDtos.add(productEntityToDto);
        }
        return productDtos;
    }

    @Override
    public ProductResponse findProductByProductId(Long productId) {
        Product product = productRepository.findProductByProductId(productId);
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .count(product.getCount())
                .isSoldout(product.isSoldout())
                .productCategoryId(product.getProductCategory().getCategoryId())
                .ingredient(product.getIngredient())
                .recipe(product.getRecipe())
                .build();
    }

    @Override
    public Long addProduct(ProductRegisterRequest productRegisterRequest) {
        ProductCategory productCategory = productCategoryRepository.findProductCategoryByCategoryId(productRegisterRequest.getProductCategoryId());
        Product productDtoToEntity = Product.builder()
                .name(productRegisterRequest.getName())
                .description(productRegisterRequest.getDescription())
                .price(productRegisterRequest.getPrice())
                .count(productRegisterRequest.getCount())
                .isSoldout(productRegisterRequest.isSoldout())
                .productCategory(productCategory)
                .ingredient(productRegisterRequest.getIngredient())
                .recipe(productRegisterRequest.getRecipe())
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
