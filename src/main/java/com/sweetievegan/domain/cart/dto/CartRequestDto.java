package com.sweetievegan.domain.cart.dto;

import com.sweetievegan.domain.cart.entity.CartProductEntity;
import com.sweetievegan.domain.product.entity.ProductEntity;
import lombok.*;

import java.util.List;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartRequestDto {
    private Long memberId;
//    private List<CartProductEntity> cartProducts;
}
