package com.sweetievegan.domain.service;

import com.sweetievegan.domain.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
    ProductDto findProductByProductId(int productId);
    void registerProduct(ProductDto productDto);
    void updateProductDetail();
    void removeProduct(int productId);
    List<ProductDto> findProductsBySearchingKeyword(String keyword, int price, boolean sale);

}
