package com.ymkim.devbooks.order.item.domain.dto.request;

public record UpdateOrderItemRequestDto(
        long orderId, int quantity
) {
}
