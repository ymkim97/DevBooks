package com.ymkim.devbooks.order.item.domain.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record UpdateOrderItemRequestDto(
        @NotNull Long orderId,
        @NotNull @Positive Integer quantity
) {
}
