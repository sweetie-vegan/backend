package com.sweetievegan.domain.cart.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="carts")
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    private int totalCount;
    private double totalPrice;

//    join members
//    join products
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn("productId")
//    private ProductEntity product;
}
