package com.sweetievegan.domain.service;

import com.sweetievegan.domain.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
    ProductDto findProductByProductId(int productId);
    int registerProduct(ProductDto productDto);
    ProductDto updateProductDetail(int productId, ProductDto productDto);
    int removeProduct(int productId);
    List<ProductDto> findProductsBySearchingKeyword(String keyword, int price, boolean sale);

}
