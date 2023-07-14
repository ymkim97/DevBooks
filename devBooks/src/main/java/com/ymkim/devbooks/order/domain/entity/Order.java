package com.ymkim.devbooks.order.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Getter
@Table("ORDERS")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Order {
    @Id
    private String orderId;
    private String address;
    private String postcode;
    private LocalDateTime createdAt;
    private List<OrderItem> orderItems;
    private OrderStatus orderStatus;

    public Order(String orderId, String address, String postcode, LocalDateTime createdAt, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.address = address;
        this.postcode = postcode;
        this.createdAt = createdAt;
        this.orderItems = Collections.emptyList();
        this.orderStatus = orderStatus;
    }
}
