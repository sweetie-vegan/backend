package com.sweetievegan.domain.service;

import com.sweetievegan.domain.dto.OrderDto;
import com.sweetievegan.domain.entity.OrderEntity;
import com.sweetievegan.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    @Override
    public List<OrderDto> getAllOrders() {
        return null;
    }

    @Override
    public Long registerOrder(OrderDto orderDto) {
        OrderEntity orderDtoToEntity = OrderEntity.builder()
                .totalPrice(orderDto.getTotalPrice())
                .count(orderDto.getCount())
                .orderName(orderDto.getOrderName())
                .address(orderDto.getAddress())
                .addressDetail(orderDto.getAddressDetail())
                .build();
        return orderRepository.save(orderDtoToEntity).getOrderId();
    }

    @Override
    public Long removeOrder(Long orderId) {
        return null;
    }

    @Override
    public OrderDto findOrderByOrderId(Long orderId) {
        return null;
    }

    @Override
    public List<OrderDto> findOrdersByMemberLoginId(String MemberLoginId) {
        return null;
    }
}
