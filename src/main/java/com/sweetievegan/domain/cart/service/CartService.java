package com.sweetievegan.domain.cart.service;

import com.sweetievegan.domain.cart.dto.CartRequestDto;
import com.sweetievegan.domain.cart.dto.CartResponseDto;

import java.util.List;

public interface CartService {
    List<CartResponseDto> findCartsByMemberId(Long memberId);
    Long registerCart(CartRequestDto cartRequestDto);
    Long removeCart(Long cartId);
}
