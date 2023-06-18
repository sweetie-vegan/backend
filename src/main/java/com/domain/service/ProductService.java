package com.domain.service;

import com.domain.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
    ProductDto findProductByProductId(Long productId);
    Long registerProduct(ProductDto productDto);
    ProductDto updateProductDetail(Long productId, ProductDto productDto);
    int removeProduct(Long productId);
    List<ProductDto> findProductsBySearchingKeyword(String keyword, int price, boolean sale);

}
