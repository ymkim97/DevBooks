package com.ymkim.devbooks.order.item.domain.dto;

import com.ymkim.devbooks.order.item.domain.entity.OrderItem;

public record OrderItemDto(
        long orderId, long bookId, int quantity
) {
    public OrderItemDto(OrderItem orderItem) {
        this(orderItem.getOrderId(), orderItem.getBookId(), orderItem.getQuantity());
    }
}
