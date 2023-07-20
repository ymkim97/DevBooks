package com.ymkim.devbooks.order.domain.dto.request;

import com.ymkim.devbooks.order.domain.entity.Order;
import com.ymkim.devbooks.order.domain.entity.OrderStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateOrderRequestDto(
        @NotNull Long customerId,
        @NotBlank String address,
        @NotBlank String postcode,
        @NotNull LocalDateTime createdAt,
        @NotNull OrderStatus orderStatus
) {
    public Order toEntity() {
        return new Order(this.customerId, this.address, this.postcode, this.createdAt, this.orderStatus);
    }
}
