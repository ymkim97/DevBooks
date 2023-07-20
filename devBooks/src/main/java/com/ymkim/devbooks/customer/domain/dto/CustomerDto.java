package com.ymkim.devbooks.customer.domain.dto;

import com.ymkim.devbooks.customer.domain.entity.Customer;
import jakarta.validation.constraints.NotBlank;

public record CustomerDto(
        @NotBlank String name,
        @NotBlank String phone,
        @NotBlank String address
) {
    public CustomerDto(Customer customer) {
        this(customer.getName(), customer.getPhone(), customer.getAddress());
    }
}
