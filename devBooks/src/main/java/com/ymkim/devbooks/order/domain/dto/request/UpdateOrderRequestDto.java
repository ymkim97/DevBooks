package com.ymkim.devbooks.order.domain.dto.request;

import com.ymkim.devbooks.order.domain.entity.OrderStatus;

public record UpdateOrderRequestDto(
        long orderId, String address, String postcode, OrderStatus orderStatus
) {
}
