package com.sweetievegan.domain.cart.entity;

import com.sweetievegan.domain.member.entity.MemberEntity;
import com.sweetievegan.domain.product.entity.ProductEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="carts")
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToOne
    @JoinColumn(name = "memberId")
    private MemberEntity member;

    @OneToMany(mappedBy = "cartId")
    private List<CartProductEntity> cartProducts = new ArrayList<>();

    @Builder
    public CartEntity(Long cartId, MemberEntity member, List<CartProductEntity> cartProducts) {
        this.cartId = cartId;
        this.member = member;
        this.cartProducts = cartProducts;
    }
}
