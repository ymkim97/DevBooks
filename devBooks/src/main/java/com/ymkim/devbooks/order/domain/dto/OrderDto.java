package com.ymkim.devbooks.order.domain.dto;

import com.ymkim.devbooks.order.domain.entity.Order;
import com.ymkim.devbooks.order.domain.entity.OrderStatus;

import java.time.LocalDateTime;

public record OrderDto(
        String address, String postcode, LocalDateTime createdAt, OrderStatus orderStatus
) {
    public OrderDto(Order order) {
        this(order.getAddress(),
                order.getPostcode(),
                order.getCreatedAt(),
                order.getOrderStatus());
    }
}
