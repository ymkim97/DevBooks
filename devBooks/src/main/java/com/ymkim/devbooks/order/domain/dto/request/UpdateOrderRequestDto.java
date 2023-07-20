package com.ymkim.devbooks.order.domain.dto.request;

import com.ymkim.devbooks.order.domain.entity.OrderStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateOrderRequestDto(
        @NotNull Long orderId,
        @NotBlank String address,
        @NotBlank String postcode,
        @NotBlank OrderStatus orderStatus
) {
}
