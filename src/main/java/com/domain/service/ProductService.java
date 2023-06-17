package com.domain.service;

import com.domain.dto.OnlyProductDto;

import java.util.List;

public interface ProductService {
    List<OnlyProductDto> getAllProducts();
    OnlyProductDto findProductByProductId(int productId);
    int registerProduct(OnlyProductDto onlyProductDto);
    OnlyProductDto updateProductDetail(int productId, OnlyProductDto onlyProductDto);
    int removeProduct(int productId);
    List<OnlyProductDto> findProductsBySearchingKeyword(String keyword, int price, boolean sale);

}
