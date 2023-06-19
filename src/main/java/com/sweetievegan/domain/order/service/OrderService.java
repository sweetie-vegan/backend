package com.sweetievegan.domain.order.service;

import com.sweetievegan.domain.order.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAllOrders();
    Long registerOrder(OrderDto orderDto);
    Long removeOrder(Long orderId);
    OrderDto findOrderByOrderId(Long orderId);
    List<OrderDto> findOrdersByMemberLoginId(String MemberLoginId);
}
