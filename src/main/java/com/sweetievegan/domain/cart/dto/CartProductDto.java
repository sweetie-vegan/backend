package com.sweetievegan.domain.cart.dto;

import com.sweetievegan.domain.cart.entity.CartEntity;
import com.sweetievegan.domain.product.entity.ProductEntity;
import lombok.*;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartProductDto {
    private Long cartProductId;
    private int count;
    private ProductEntity product;
    private CartEntity cart;
}
