package com.sweetievegan.domain.cart.dto;

import com.sweetievegan.domain.product.entity.ProductEntity;
import lombok.*;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartRequestDto {
    private int totalCount;
    private double totalPrice;
    private Long cartProductId;
    private Long memberId;
}
