package com.ymkim.devbooks.customer.domain.dto;

import com.ymkim.devbooks.customer.domain.entity.Customer;

public record CustomerDto(
        long customerId, String name, String phone, String address
) {
    public CustomerDto(Customer customer) {
        this(customer.getCustomerId(),
                customer.getName(),
                customer.getPhone(),
                customer.getAddress());
    }
}
