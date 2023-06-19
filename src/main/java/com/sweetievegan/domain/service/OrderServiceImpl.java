package com.sweetievegan.domain.service;

import com.sweetievegan.domain.dto.OrderDto;
import com.sweetievegan.domain.entity.OrderEntity;
import com.sweetievegan.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    @Override
    public List<OrderDto> getAllOrders() {
        List<OrderEntity> orderEntities = orderRepository.findAll();
        List<OrderDto> orderEntitiesToDtos = new ArrayList<>();
        for(OrderEntity orderEntity : orderEntities) {
            OrderDto orderEntityToDto = OrderDto.builder()
                    .orderId(orderEntity.getOrderId())
                    .orderDate(orderEntity.getOrderDate())
                    .totalPrice(orderEntity.getTotalPrice())
                    .count(orderEntity.getCount())
                    .orderName(orderEntity.getOrderName())
                    .address(orderEntity.getAddress())
                    .addressDetail(orderEntity.getAddressDetail())
                    .build();
            orderEntitiesToDtos.add(orderEntityToDto);
        }
        return orderEntitiesToDtos;
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
        orderRepository.deleteById(orderId);
        return orderId;
    }

    @Override
    public OrderDto findOrderByOrderId(Long orderId) {
        OrderEntity orderEntity = orderRepository.findOrderByOrderId(orderId);
        OrderDto orderEntityToDto = OrderDto.builder()
                .orderId(orderEntity.getOrderId())
                .orderDate(orderEntity.getOrderDate())
                .totalPrice(orderEntity.getTotalPrice())
                .count(orderEntity.getCount())
                .orderName(orderEntity.getOrderName())
                .address(orderEntity.getAddress())
                .addressDetail(orderEntity.getAddressDetail())
                .build();
        return orderEntityToDto;
    }

    @Override
    public List<OrderDto> findOrdersByMemberLoginId(String memberLoginId) {
        List<OrderEntity> orderEntities = orderRepository.findOrdersByMemberLoginId(memberLoginId);
        List<OrderDto> orderEntitiesToDtos = new ArrayList<>();
        for(OrderEntity orderEntity : orderEntities) {
            OrderDto orderEntityToDto = OrderDto.builder()
                    .orderId(orderEntity.getOrderId())
                    .orderDate(orderEntity.getOrderDate())
                    .totalPrice(orderEntity.getTotalPrice())
                    .count(orderEntity.getCount())
                    .orderName(orderEntity.getOrderName())
                    .address(orderEntity.getAddress())
                    .addressDetail(orderEntity.getAddressDetail())
                    .build();
            orderEntitiesToDtos.add(orderEntityToDto);
        }
        return orderEntitiesToDtos;
    }
}
