package com.sweetievegan.domain.cart.dto;

import com.sweetievegan.domain.product.dto.ProductResponseDto;
import com.sweetievegan.domain.product.entity.ProductEntity;
import lombok.*;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartProductResponseDto {
    private ProductResponseDto product;
    private int count;
}
