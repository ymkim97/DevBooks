package com.ymkim.devbooks.order.domain.dto.request;

import com.ymkim.devbooks.order.domain.entity.Order;
import com.ymkim.devbooks.order.domain.entity.OrderStatus;

import java.time.LocalDateTime;

public record CreateOrderRequestDto(
        long customerId, String address, String postcode, LocalDateTime createdAt, OrderStatus orderStatus
) {
    public Order toEntity() {
        return new Order(this.customerId, this.address, this.postcode, this.createdAt, this.orderStatus);
    }
}
