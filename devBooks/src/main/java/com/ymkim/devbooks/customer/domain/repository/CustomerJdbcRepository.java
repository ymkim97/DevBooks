package com.ymkim.devbooks.customer.domain.repository;

import com.ymkim.devbooks.customer.domain.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerJdbcRepository extends CrudRepository<Customer, Long> {
}
