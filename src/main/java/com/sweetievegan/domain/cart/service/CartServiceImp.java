package com.sweetievegan.domain.cart.service;

import com.sweetievegan.domain.cart.dto.CartProductResponseDto;
import com.sweetievegan.domain.cart.dto.CartRequestDto;
import com.sweetievegan.domain.cart.dto.CartResponseDto;
import com.sweetievegan.domain.cart.entity.CartEntity;
import com.sweetievegan.domain.cart.entity.CartProductEntity;
import com.sweetievegan.domain.cart.repository.CartRepository;
import com.sweetievegan.domain.member.entity.MemberEntity;
import com.sweetievegan.domain.member.repository.MemberRepository;
import com.sweetievegan.domain.product.service.ProductServiceImp;
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
    private final MemberRepository memberRepository;
    private final ProductServiceImp productServiceImp;

    @Override
    public CartResponseDto findCartsByMemberId(Long memberId) {
        MemberEntity memberTofind = memberRepository.findMemberByMemberId(memberId);
       CartEntity cartEntity = cartRepository.findByMember(memberTofind);
       CartResponseDto cartResponseDto = CartResponseDto.builder()
               .memberId(cartEntity.getMember().getMemberId())
               .cartId(cartEntity.getCartId())
               .cartProducts(cartProductEntityToDto(cartEntity.getCartProducts()))
               .build();
       return cartResponseDto;
    }

    public List<CartProductResponseDto> cartProductEntityToDto(List<CartProductEntity> cartProductEntities) {
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
    public Long registerCart(CartRequestDto cartRequestDto) {
        CartEntity cartDtoToEntity = CartEntity.builder()
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