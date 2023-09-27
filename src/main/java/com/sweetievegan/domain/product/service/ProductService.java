package com.sweetievegan.domain.product.service;

import com.sweetievegan.domain.product.dto.ProductRegisterRequest;
import com.sweetievegan.domain.product.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProducts();
    ProductResponse findProductByProductId(Long productId);
    Long registerProduct(ProductRegisterRequest productRegisterRequest);
    ProductRegisterRequest updateProductDetail(Long productId, ProductRegisterRequest productRegisterRequest);
    Long removeProduct(Long productId);
    List<ProductRegisterRequest> findProductsBySearchingKeyword(String keyword, int price, boolean sale);
}
