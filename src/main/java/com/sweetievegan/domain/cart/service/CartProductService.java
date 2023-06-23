package com.sweetievegan.domain.cart.service;

import com.sweetievegan.domain.cart.dto.CartRequestDto;
import com.sweetievegan.domain.cart.entity.CartProductEntity;

import java.util.List;

public interface CartProductService {
    List<CartProductEntity> findCartProductsByCartId(Long cartId);
    CartProductEntity registerCartProduct(Long cartId, CartRequestDto cartRequestDto);
    Long removeCartProduct(Long cartId, Long cartProductId);
}
