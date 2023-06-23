package com.sweetievegan.domain.cart.service;

import com.sweetievegan.domain.cart.dto.CartRequestDto;
import com.sweetievegan.domain.cart.dto.CartResponseDto;
import com.sweetievegan.domain.cart.entity.CartEntity;
import com.sweetievegan.domain.cart.repository.CartRepository;
import com.sweetievegan.domain.member.repository.MemberRepository;
import com.sweetievegan.domain.product.repository.ProductCategoryRepository;
import com.sweetievegan.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CartServiceImp implements CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final MemberRepository memberRepository;

    @Override
    public List<CartResponseDto> findCartsByMemberId(Long memberId) {
//        List<CartEntity> cartEntities = cartRepository.findCartsByMemberId(memberId);
        List<CartResponseDto> cartResponseDtos = new ArrayList<>();
//        for(CartEntity cartEntity : cartEntities) {
//            CartResponseDto cartResponseDto = CartResponseDto.builder()
//                    .cartId(cartEntity.getCartId())
//                    .totalCount(cartEntity.getTotalCount())
//                    .totalPrice(cartEntity.getTotalPrice())
//                    .product(cartEntity.getProduct())
//                    .memberId(cartEntity.getMember().getMemberId())
//                    .build();
//            cartResponseDtos.add(cartResponseDto);
//        }
        return cartResponseDtos;
    }

    @Override
    public Long registerCart(CartRequestDto cartRequestDto) {
        CartEntity cartDtoToEntity = CartEntity.builder()
                .totalCount(cartRequestDto.getTotalCount())
                .totalPrice(cartRequestDto.getTotalPrice())
                .member(memberRepository.findMemberByMemberId(cartRequestDto.getMemberId()))
                .build();
        cartRepository.save(cartDtoToEntity);
        return cartDtoToEntity.getCartId();
    }

    @Override
    public Long removeCart(Long cartId) {
        cartRepository.deleteById(cartId);
        return cartId;
    }
}