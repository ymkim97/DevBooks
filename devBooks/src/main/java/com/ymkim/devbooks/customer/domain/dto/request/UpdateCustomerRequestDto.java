package com.ymkim.devbooks.customer.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateCustomerRequestDto(

        @NotNull Long customerId,
        @NotBlank String phone,
        @NotBlank String address
) {
}
