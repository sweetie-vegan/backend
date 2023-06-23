package com.sweetievegan.domain.cart.entity;

import com.sweetievegan.domain.product.entity.ProductEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "cart_products")
public class CartProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartProductId;

    private int count;

    @OneToOne
    @JoinColumn(name = "productId")
    private ProductEntity product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cartId")
    private CartEntity cart;

    @Builder
    public CartProductEntity(Long cartProductId, int count, ProductEntity product, CartEntity cart) {
        this.cartProductId = cartProductId;
        this.count = count;
        this.product = product;
        this.cart = cart;
    }
}
