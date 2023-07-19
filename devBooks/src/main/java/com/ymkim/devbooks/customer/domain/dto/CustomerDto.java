package com.ymkim.devbooks.customer.domain.dto;

import com.ymkim.devbooks.customer.domain.entity.Customer;

public record CustomerDto(
        String name, String phone, String address
) {
    public CustomerDto(Customer customer) {
        this(customer.getName(),
                customer.getPhone(),
                customer.getAddress());
    }
}
