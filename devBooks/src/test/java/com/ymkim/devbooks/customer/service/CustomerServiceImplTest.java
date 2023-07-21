package com.ymkim.devbooks.customer.service;

import com.ymkim.devbooks.customer.domain.dto.CustomerDto;
import com.ymkim.devbooks.customer.domain.dto.request.CreateCustomerRequestDto;
import com.ymkim.devbooks.customer.domain.dto.request.UpdateCustomerRequestDto;
import com.ymkim.devbooks.customer.domain.repository.CustomerJdbcRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class CustomerServiceImplTest {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerJdbcRepository customerRepository;

    @AfterEach
    void cleanUp(){
        customerRepository.deleteAll();
    }

    @Test
    @DisplayName("Customer 생성 test")
    void testCreateCustomer() {
        // given
        CreateCustomerRequestDto customerRequestDto = new CreateCustomerRequestDto("Test", "0101111", "Test-Address");

        // when
        long savedId = customerService.createCustomer(customerRequestDto);
        Optional<CustomerDto> customer = customerService.findCustomer(savedId);

        // then
        assertThat(customer).isNotEmpty();
    }

    @Test
    @DisplayName("모든 Customer 가져오기 test")
    void testGetAllCustomers() {
        // given
        CreateCustomerRequestDto customerRequestDto1 = new CreateCustomerRequestDto("Test1", "0101111", "Test-Address1");
        CreateCustomerRequestDto customerRequestDto2 = new CreateCustomerRequestDto("Test2", "044444", "Test-Address2");

        // when
        customerService.createCustomer(customerRequestDto1);
        customerService.createCustomer(customerRequestDto2);
        List<CustomerDto> customers = customerService.getAllCustomers();

        // then
        assertThat(customers).hasSize(2);
    }

    @Test
    @DisplayName("Id로 Customer 삭제 test")
    void testDeleteCustomerById() {
        // given
        CreateCustomerRequestDto customerRequestDto1 = new CreateCustomerRequestDto("Test1", "0101111", "Test-Address1");
        CreateCustomerRequestDto customerRequestDto2 = new CreateCustomerRequestDto("Test2", "044444", "Test-Address2");

        // when
        long customerId = customerService.createCustomer(customerRequestDto1);
        customerService.createCustomer(customerRequestDto2);
        customerService.deleteCustomer(customerId);
        List<CustomerDto> customers = customerService.getAllCustomers();

        // then
        assertThat(customers).hasSize(1);
    }

    @Test
    @DisplayName("Order 업데이트 test")
    void testUpdateCustomer() {
        // given
        CreateCustomerRequestDto customerRequestDto1 = new CreateCustomerRequestDto("Test1", "0101111", "Test-Address1");
        long customerId = customerService.createCustomer(customerRequestDto1);
        UpdateCustomerRequestDto updateCustomerRequestDto = new UpdateCustomerRequestDto(customerId, "2222", "Update-Address");

        // when
        customerService.updateCustomer(updateCustomerRequestDto);
        Optional<CustomerDto> customerDto = customerService.findCustomer(customerId);

        // then
        assertThat(customerDto.get().phone()).isEqualTo(updateCustomerRequestDto.phone());
        assertThat(customerDto.get().address()).isEqualTo(updateCustomerRequestDto.address());
    }
}