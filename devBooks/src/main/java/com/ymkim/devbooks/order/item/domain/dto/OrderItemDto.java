package com.ymkim.devbooks.order.item.domain.dto;

import com.ymkim.devbooks.order.item.domain.entity.OrderItem;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderItemDto(
        @NotNull Long orderId,
        @NotNull Long bookId,
        @NotNull @Positive Integer quantity
) {
    public OrderItemDto(OrderItem orderItem) {
        this(orderItem.getOrderId(), orderItem.getBookId(), orderItem.getQuantity());
    }

    public OrderItem toEntity() {
        return new OrderItem(this.orderId, this.bookId, this.quantity);
    }
}
