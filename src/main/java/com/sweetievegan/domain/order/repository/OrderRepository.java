package com.sweetievegan.domain.order.repository;

import com.sweetievegan.domain.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    OrderEntity findOrderByOrderId(Long OrderId);
    List<OrderEntity> findOrdersByMemberLoginId(String loginId);
}
