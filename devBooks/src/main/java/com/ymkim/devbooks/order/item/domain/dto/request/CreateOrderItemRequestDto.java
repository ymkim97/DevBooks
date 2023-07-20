package com.ymkim.devbooks.order.item.domain.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateOrderItemRequestDto(
        @NotNull Long bookId,
        @NotNull @Positive Integer quantity
) {
}
