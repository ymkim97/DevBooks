package com.ymkim.devbooks.customer.service;

import com.ymkim.devbooks.customer.domain.dto.CustomerDto;
import com.ymkim.devbooks.customer.domain.dto.request.CreateCustomerRequestDto;
import com.ymkim.devbooks.customer.domain.dto.request.UpdateCustomerRequestDto;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Long createCustomer(CreateCustomerRequestDto createCustomerRequestDto);

    Optional<CustomerDto> findCustomerById(long id);

    List<CustomerDto> getAllCustomers();

    void deleteCustomerById(long id);

    CustomerDto updateCustomer(UpdateCustomerRequestDto updateCustomerRequestDto);
}
