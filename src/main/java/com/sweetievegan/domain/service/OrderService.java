package com.sweetievegan.domain.service;

import com.sweetievegan.domain.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAllOrders();
    int registerOrder(OrderDto orderDto);
    int removeOrder(Long orderId);
    OrderDto findOrderByOrderId(Long orderId);
    List<OrderDto> findOrdersByMemberId(Long memberId);
}
