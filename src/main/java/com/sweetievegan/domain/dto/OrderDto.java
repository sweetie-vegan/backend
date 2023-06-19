package com.sweetievegan.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderDto {
    private Long orderId;
    private LocalDateTime orderDate;
    private int totalPrice;
    private int count;
    private String orderName;
    private String address;
    private String addressDetail;
    private String tel;

    @Builder
    public OrderDto(Long orderId, LocalDateTime orderDate, int totalPrice, int count, String orderName, String address, String addressDetail, String tel) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.count = count;
        this.orderName = orderName;
        this.address = address;
        this.addressDetail = addressDetail;
        this.tel = tel;
    }
}
