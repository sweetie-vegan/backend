package com.sweetievegan.domain.cart.repository;

import com.sweetievegan.domain.cart.entity.CartProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartProductRepository extends JpaRepository<CartProductEntity, Long> {
    List<CartProductEntity> findByCartCartId(Long cartId);

}
