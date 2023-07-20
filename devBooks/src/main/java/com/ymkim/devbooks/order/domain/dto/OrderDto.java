package com.ymkim.devbooks.order.domain.dto;

import com.ymkim.devbooks.order.domain.entity.Order;
import com.ymkim.devbooks.order.domain.entity.OrderStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record OrderDto(
        @NotBlank String address,
        @NotBlank String postcode,
        @NotNull LocalDateTime createdAt,
        @NotNull OrderStatus orderStatus
) {
    public OrderDto(Order order) {
        this(order.getAddress(),
                order.getPostcode(),
                order.getCreatedAt(),
                order.getOrderStatus());
    }
}
