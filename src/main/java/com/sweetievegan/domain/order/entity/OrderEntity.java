package com.sweetievegan.domain.order.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @CreatedDate
    private LocalDateTime orderDate;

    private int totalPrice;
    private int count;
    private String orderName;
    private String address;
    private String addressDetail;
    private String tel;

    @Builder
    public OrderEntity(int totalPrice, int count, String orderName, String address, String addressDetail, String tel) {
        this.totalPrice = totalPrice;
        this.count = count;
        this.orderName = orderName;
        this.address = address;
        this.addressDetail = addressDetail;
        this.tel = tel;
    }
}
