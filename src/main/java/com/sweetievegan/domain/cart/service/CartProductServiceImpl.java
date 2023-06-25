package com.sweetievegan.domain.cart.service;

import com.sweetievegan.domain.cart.dto.CartProductDto;
import com.sweetievegan.domain.cart.dto.CartRequestDto;
import com.sweetievegan.domain.cart.entity.CartProductEntity;
import com.sweetievegan.domain.cart.repository.CartProductRepository;
import com.sweetievegan.domain.cart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CartProductServiceImpl implements CartProductService {
    private final CartRepository cartRepository;
    private final CartProductRepository cartProductRepository;

    @Override
    public List<CartProductDto> findCartProductsByCartId(Long cartId) {
        List<CartProductEntity> cartProductEntities = cartProductRepository.findCartProductsByCartId(cartId);
        List<CartProductDto> cartProductDtos = new ArrayList<>();
        for(CartProductEntity cartProductEntity : cartProductEntities) {
            CartProductDto cartProductDto = CartProductDto.builder()
                    .cartProductId(cartProductEntity.getCartProductId())
                    .count(cartProductEntity.getCount())
                    .product(cartProductEntity.getProduct())
                    .build();
            cartProductDtos.add(cartProductDto);
        }
        return cartProductDtos;
    }

    @Override
    public CartProductEntity registerCartProduct(Long cartId, CartRequestDto cartRequestDto) {
        return null;
    }

    @Override
    public Long removeCartProduct(Long cartId, Long cartProductId) {
        return null;
    }
}
