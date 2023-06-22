package com.sweetievegan.domain.cart.repository;

import com.sweetievegan.domain.cart.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<CartEntity, Long> {
//    List<CartEntity> findCartsByMemberId(Long memberId);
}
