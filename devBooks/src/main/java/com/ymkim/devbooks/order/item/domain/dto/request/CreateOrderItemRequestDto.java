package com.ymkim.devbooks.order.item.domain.dto.request;

import com.ymkim.devbooks.order.item.domain.entity.OrderItem;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateOrderItemRequestDto(
        @NotNull Long orderId,
        @NotNull Long bookId,
        @NotNull @Positive Integer quantity
) {
    public OrderItem toEntity() {
        return new OrderItem(this.orderId, this.bookId, this.quantity);
    }
}
