package com.ymkim.devbooks.order.item.domain.dto.request;

public record CreateOrderItemRequestDto(
        long orderId, long bookId, int quantity
) {
}
