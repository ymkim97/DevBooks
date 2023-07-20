package com.ymkim.devbooks.order.service;

import com.ymkim.devbooks.customer.domain.entity.Customer;
import com.ymkim.devbooks.customer.domain.repository.CustomerJdbcRepository;
import com.ymkim.devbooks.order.domain.dto.OrderDto;
import com.ymkim.devbooks.order.domain.dto.request.CreateOrderRequestDto;
import com.ymkim.devbooks.order.domain.dto.request.UpdateOrderRequestDto;
import com.ymkim.devbooks.order.domain.entity.OrderStatus;
import com.ymkim.devbooks.order.domain.repository.OrderRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OrderServiceImplTest {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerJdbcRepository customerRepository;

    long customerId;

    @BeforeAll
    void setUp() {
        customerId = customerRepository.save(
                new Customer("TestCustomer", "TestPhone", "TestAddress"))
                .getCustomerId();
    }

    @AfterEach
    void clean() {
        orderRepository.deleteAll();
    }

    @Test
    @DisplayName("Order 생성 test")
    void createOrderTest() {
        // given
        CreateOrderRequestDto orderRequestDto = new CreateOrderRequestDto(customerId,
                "Test Address",
                "12345",
                LocalDateTime.now(),
                OrderStatus.ACCEPTED,
                Collections.emptyList());

        // when
        long id = orderService.createOrder(orderRequestDto);
        Optional<OrderDto> orderDto = orderService.findOrderById(id);

        //then
        assertThat(orderDto).isNotEmpty();
    }

    @Test
    @DisplayName("모든 order 가져오기 test")
    void testGetAllOrders() {
        // given
        CreateOrderRequestDto orderRequestDto1 = new CreateOrderRequestDto(customerId,
                "Test Address1",
                "12345",
                LocalDateTime.now(),
                OrderStatus.ACCEPTED,
                Collections.emptyList());
        CreateOrderRequestDto orderRequestDto2 = new CreateOrderRequestDto(customerId,
                "Test Address2",
                "67890",
                LocalDateTime.now(),
                OrderStatus.READY_FOR_DELIVERY,
                Collections.emptyList());

        // when
        orderService.createOrder(orderRequestDto1);
        orderService.createOrder(orderRequestDto2);
        List<OrderDto> allOrders = orderService.getAllOrders();

        //then
        assertThat(allOrders).hasSize(2);
    }

    @Test
    @DisplayName("Id로 Order 삭제 test")
    void testDeleteOrderById() {
        // given
        CreateOrderRequestDto orderRequestDto1 = new CreateOrderRequestDto(customerId,
                "Test Address1",
                "12345",
                LocalDateTime.now(),
                OrderStatus.ACCEPTED,
                Collections.emptyList());
        CreateOrderRequestDto orderRequestDto2 = new CreateOrderRequestDto(customerId,
                "Test Address2",
                "67890",
                LocalDateTime.now(),
                OrderStatus.READY_FOR_DELIVERY,
                Collections.emptyList());

        // when
        long orderId = orderService.createOrder(orderRequestDto1);
        orderService.createOrder(orderRequestDto2);
        orderService.deleteOrderById(orderId);
        List<OrderDto> allOrders = orderService.getAllOrders();

        // then
        assertThat(allOrders).hasSize(1);
    }

    @Test
    @DisplayName("Order 업데이트 test")
    void testUpdateOrder() {
        // given
        CreateOrderRequestDto orderRequestDto1 = new CreateOrderRequestDto(customerId,
                "Test Address1",
                "12345",
                LocalDateTime.now(),
                OrderStatus.ACCEPTED,
                Collections.emptyList());
        long orderId = orderService.createOrder(orderRequestDto1);
        UpdateOrderRequestDto updateOrderRequestDto = new UpdateOrderRequestDto(orderId,
                "Update Test Address",
                "7777",
                OrderStatus.SHIPPED);

        // when
        orderService.updateOrder(updateOrderRequestDto);
        Optional<OrderDto> orderDto = orderService.findOrderById(orderId);

        // then
        assertThat(orderDto.get().address()).isEqualTo(updateOrderRequestDto.address());
        assertThat(orderDto.get().postcode()).isEqualTo(updateOrderRequestDto.postcode());
    }
}