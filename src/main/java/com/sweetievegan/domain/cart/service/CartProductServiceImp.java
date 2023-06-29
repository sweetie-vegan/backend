package com.sweetievegan.domain.cart.service;

import com.sweetievegan.domain.cart.dto.CartProductResponseDto;
import com.sweetievegan.domain.cart.dto.CartRequestDto;
import com.sweetievegan.domain.cart.entity.CartEntity;
import com.sweetievegan.domain.cart.entity.CartProductEntity;
import com.sweetievegan.domain.cart.repository.CartProductRepository;
import com.sweetievegan.domain.cart.repository.CartRepository;
import com.sweetievegan.domain.product.service.ProductServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CartProductServiceImp implements CartProductService {
    private final CartRepository cartRepository;
    private final CartProductRepository cartProductRepository;
    private final ProductServiceImp productServiceImp;

    @Override
    public List<CartProductResponseDto> findCartProductsByCartId(Long cartId) {
        List<CartProductEntity> cartProductEntities = cartProductRepository.findByCartCartId(cartId);
        List<CartProductResponseDto> cartProductResponseDtos = new ArrayList<>();
        for(CartProductEntity cartProductEntity : cartProductEntities) {
            CartProductResponseDto cartProductResponseDto = CartProductResponseDto.builder()
                    .product(productServiceImp.productEntityToDto(cartProductEntity.getProduct()))
                    .count(cartProductEntity.getCount())
                    .build();
            cartProductResponseDtos.add(cartProductResponseDto);
        }
        return cartProductResponseDtos;
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
