package com.ymkim.devbooks.customer.domain.dto.request;

import com.ymkim.devbooks.customer.domain.entity.Customer;
import jakarta.validation.constraints.NotBlank;

public record CreateCustomerRequestDto(
        @NotBlank String name,
        @NotBlank String phone,
        @NotBlank String address
) {
    public Customer toEntity() {
        return new Customer(this.name, this.phone, this.address);
    }
}
