package com.sweetievegan.domain.cart.service;

import com.sweetievegan.domain.cart.dto.CartProductRequestDto;
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
    public List<CartProductRequestDto> findCartProductsByCartId(Long cartId) {
        List<CartProductEntity> cartProductEntities = cartProductRepository.findCartProductsByCartId(cartId);
        List<CartProductRequestDto> cartProductRequestDtos = new ArrayList<>();
        for(CartProductEntity cartProductEntity : cartProductEntities) {
            CartProductRequestDto cartProductRequestDto = CartProductRequestDto.builder()
                    .cartProductId(cartProductEntity.getCartProductId())
                    .count(cartProductEntity.getCount())
                    .cartId(cartProductEntity.getCart().getCartId())
                    .productId(cartProductEntity.getProduct().getProductId())
                    .build();
            cartProductRequestDtos.add(cartProductRequestDto);
        }
        return cartProductRequestDtos;
    }

    @Override
    public CartProductEntity registerCartProduct(Long cartId, CartRequestDto cartRequestDto) {
        Car
        return null;
    }

    @Override
    public Long removeCartProduct(Long cartId, Long cartProductId) {
        return null;
    }
}
