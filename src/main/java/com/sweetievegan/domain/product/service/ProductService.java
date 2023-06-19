package com.sweetievegan.domain.product.service;

import com.sweetievegan.domain.product.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
    ProductDto findProductByProductId(Long productId);
    Long registerProduct(ProductDto productDto);
    ProductDto updateProductDetail(Long productId, ProductDto productDto);
    Long removeProduct(Long productId);
    List<ProductDto> findProductsBySearchingKeyword(String keyword, int price, boolean sale);

}
