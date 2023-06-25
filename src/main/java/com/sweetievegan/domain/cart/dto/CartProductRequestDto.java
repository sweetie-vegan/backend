package com.sweetievegan.domain.cart.dto;

import lombok.*;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartProductRequestDto {
    private int count;
    private Long cartId;
    private Long productId;
}
