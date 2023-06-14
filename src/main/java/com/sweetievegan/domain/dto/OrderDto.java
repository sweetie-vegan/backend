package com.sweetievegan.domain.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
public class OrderDto {
    private Long orderId;
    private LocalDateTime orderDate;
    private int price;
    private int count;
    private String orderName;
    private String address;
    private String addressDetail;
    private String tel;

    @Builder
    public OrderDto(Long orderId, LocalDateTime orderDate, int price, int count, String orderName, String address, String addressDetail, String tel) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.price = price;
        this.count = count;
        this.orderName = orderName;
        this.address = address;
        this.addressDetail = addressDetail;
        this.tel = tel;
    }
}
