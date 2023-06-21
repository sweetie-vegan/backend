package com.sweetievegan.domain.cart.dto;

import com.sweetievegan.domain.product.entity.ProductEntity;
import lombok.*;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartResponseDto {
    private Long cartId;
    private int totalCount;
    private double totalPrice;
    private ProductEntity product;
    private Long memberId;
}
