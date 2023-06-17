package com.domain.service;

import com.domain.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
    ProductDto findProductByProductId(int productId);
    Long registerProduct(ProductDto productDto);
    ProductDto updateProductDetail(int productId, ProductDto productDto);
    int removeProduct(int productId);
    List<ProductDto> findProductsBySearchingKeyword(String keyword, int price, boolean sale);

}
