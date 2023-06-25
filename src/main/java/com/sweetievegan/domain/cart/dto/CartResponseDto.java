package com.sweetievegan.domain.cart.dto;

import com.sweetievegan.domain.cart.entity.CartProductEntity;
import com.sweetievegan.domain.product.entity.ProductEntity;
import lombok.*;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartResponseDto {
    private Long cartId;
    private Long memberId;
    private List<CartProductEntity> cartProducts;
//    private int totalCount;
//    private double totalPrice;
}
