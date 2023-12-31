package com.ymkim.devbooks.customer.service;

import com.ymkim.devbooks.customer.domain.dto.CustomerDto;
import com.ymkim.devbooks.customer.domain.dto.request.CreateCustomerRequestDto;
import com.ymkim.devbooks.customer.domain.dto.request.UpdateCustomerRequestDto;
import com.ymkim.devbooks.customer.domain.entity.Customer;
import com.ymkim.devbooks.customer.domain.repository.CustomerJdbcRepository;
import com.ymkim.devbooks.global.ExceptionMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerJdbcRepository customerRepository;

    @Override
    @Transactional
    public Long createCustomer(CreateCustomerRequestDto createCustomerRequestDto) {
        Customer savedCustomer = customerRepository.save(createCustomerRequestDto.toEntity());
        return savedCustomer.getCustomerId();
    }

    @Override
    public Optional<CustomerDto> findCustomer(long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.map(CustomerDto::new);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return StreamSupport.stream(customerRepository.findAll().spliterator(), false)
                .map(CustomerDto::new)
                .toList();
    }

    @Override
    @Transactional
    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }

    @Override
    @Transactional
    public CustomerDto updateCustomer(UpdateCustomerRequestDto customerRequestDto) {
        Customer customer = customerRepository.findById(customerRequestDto.customerId())
                .orElseThrow(() -> new NoSuchElementException(ExceptionMessages.NO_CUSTOMER_FOUND_BY_ID_ERROR.getMessage()));

        customer.update(customerRequestDto.phone(), customerRequestDto.address());
        customerRepository.save(customer);
        return new CustomerDto(customer);
    }
}
