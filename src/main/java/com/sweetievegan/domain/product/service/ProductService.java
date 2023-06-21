package com.sweetievegan.domain.product.service;

import com.sweetievegan.domain.product.dto.ProductRequestDto;
import com.sweetievegan.domain.product.dto.ProductResponseDto;

import java.util.List;

public interface ProductService {
    List<ProductResponseDto> getAllProducts();
    ProductResponseDto findProductByProductId(Long productId);
    Long registerProduct(ProductRequestDto productRequestDto);
    ProductRequestDto updateProductDetail(Long productId, ProductRequestDto productRequestDto);
    Long removeProduct(Long productId);
    List<ProductRequestDto> findProductsBySearchingKeyword(String keyword, int price, boolean sale);

}
