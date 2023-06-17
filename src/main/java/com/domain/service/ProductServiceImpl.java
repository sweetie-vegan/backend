package com.domain.service;

import com.domain.dto.OnlyProductDto;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public List<OnlyProductDto> getAllProducts() {
        return null;
    }

    @Override
    public OnlyProductDto findProductByProductId(int productId) {
        return null;
    }

    @Override
    public int registerProduct(OnlyProductDto onlyProductDto) {
        return 0;
    }

    @Override
    public OnlyProductDto updateProductDetail(int productId, OnlyProductDto onlyProductDto) {
        return null;
    }

    @Override
    public int removeProduct(int productId) {
        return 0;
    }

    @Override
    public List<OnlyProductDto> findProductsBySearchingKeyword(String keyword, int price, boolean sale) {
        return null;
    }
}
