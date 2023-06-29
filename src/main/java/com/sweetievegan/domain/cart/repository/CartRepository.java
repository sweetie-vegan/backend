package com.sweetievegan.domain.cart.repository;

import com.sweetievegan.domain.cart.entity.CartEntity;
import com.sweetievegan.domain.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {
    CartEntity findByMember(MemberEntity member);
    CartEntity findCartByCartId(Long cartId);
}
