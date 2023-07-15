package com.ymkim.devbooks.customer.domain.repository;

import com.ymkim.devbooks.customer.domain.entity.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class CustomerJdbcRepositoryTest {

    @Autowired
    CustomerJdbcRepository customerRepository;

    @Test
    @DisplayName("Customer save test")
    void saveTest() {
        // given
        var customer = new Customer("Test", "1234", "ddddd");

        // when
        customerRepository.save(customer);
        var savedCustomer = customerRepository.findById(customer.getCustomerId());

        // then
        assertThat(savedCustomer).isNotEmpty();
        assertThat(savedCustomer.get().getCustomerId()).isEqualTo(customer.getCustomerId());

    }
}