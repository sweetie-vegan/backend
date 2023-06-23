package com.sweetievegan.domain.cart.dto;

import com.sweetievegan.domain.cart.entity.CartProductEntity;
import com.sweetievegan.domain.product.entity.ProductEntity;
import lombok.*;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartRequestDto {
    private CartProductEntity cartProduct;
    private Long memberId;
}
