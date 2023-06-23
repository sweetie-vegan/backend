package com.sweetievegan.domain.cart.entity;

import com.sweetievegan.domain.member.entity.MemberEntity;
import com.sweetievegan.domain.product.entity.ProductEntity;
import lombok.AccessLevel;
import lombok.Builder;
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

    @OneToOne
    @JoinColumn(name = "memberId")
    private MemberEntity member;

    @Builder
    public CartEntity(Long cartId, int totalCount, double totalPrice,  MemberEntity member) {
        this.cartId = cartId;
        this.totalCount = totalCount;
        this.totalPrice = totalPrice;
        this.member = member;
    }
}
