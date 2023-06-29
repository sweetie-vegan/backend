package com.sweetievegan.domain.cart.entity;

import com.sweetievegan.domain.member.entity.MemberEntity;
import com.sweetievegan.domain.product.entity.ProductEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name="carts")
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToOne
    @JoinColumn(name = "memberId")
    private MemberEntity member;

    @OneToMany(mappedBy = "cart")
    private List<CartProductEntity> cartProducts = new ArrayList<>();

}
