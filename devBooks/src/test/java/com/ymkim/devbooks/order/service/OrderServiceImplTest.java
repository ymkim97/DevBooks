package com.ymkim.devbooks.order.service;

import com.ymkim.devbooks.order.domain.dto.OrderDto;
import com.ymkim.devbooks.order.domain.dto.request.CreateOrderRequestDto;
import com.ymkim.devbooks.order.domain.dto.request.UpdateOrderRequestDto;
import com.ymkim.devbooks.order.domain.entity.OrderStatus;
import com.ymkim.devbooks.order.domain.repository.OrderRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class OrderServiceImplTest {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @AfterEach
    void cleanUp() {
        orderRepository.deleteAll();
    }

    @Test
    @DisplayName("Order 생성 test")
    void createOrderTest() {
        // given
        CreateOrderRequestDto orderRequestDto = new CreateOrderRequestDto("Test Address", "12345", LocalDateTime.now(), OrderStatus.ACCEPTED);

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
        CreateOrderRequestDto orderRequestDto1 = new CreateOrderRequestDto("Test Address1", "12345", LocalDateTime.now(), OrderStatus.ACCEPTED);
        CreateOrderRequestDto orderRequestDto2 = new CreateOrderRequestDto("Test Address2", "67890", LocalDateTime.now(), OrderStatus.READY_FOR_DELIVERY);

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
        CreateOrderRequestDto orderRequestDto1 = new CreateOrderRequestDto("Test Address1", "12345", LocalDateTime.now(), OrderStatus.ACCEPTED);
        CreateOrderRequestDto orderRequestDto2 = new CreateOrderRequestDto("Test Address2", "67890", LocalDateTime.now(), OrderStatus.READY_FOR_DELIVERY);

        // when
        long orderId = orderService.createOrder(orderRequestDto1);
        orderService.createOrder(orderRequestDto2);
        Optional<OrderDto> orderDto = orderService.findOrderById(orderId);
        orderService.deleteOrderById(orderDto.get().orderId());
        List<OrderDto> allOrders = orderService.getAllOrders();

        // then
        assertThat(allOrders).hasSize(1);
    }

    @Test
    @DisplayName("Order 업데이트 test")
    void testUpdateOrder() {
        // given
        CreateOrderRequestDto orderRequestDto1 = new CreateOrderRequestDto("Test Address1", "12345", LocalDateTime.now(), OrderStatus.ACCEPTED);
        long orderId = orderService.createOrder(orderRequestDto1);
        UpdateOrderRequestDto updateOrderRequestDto = new UpdateOrderRequestDto(orderId, "Update Test Address", "7777", OrderStatus.SHIPPED);

        // when
        OrderDto orderDto = orderService.updateOrder(updateOrderRequestDto);
        orderService.findOrderById(orderId);

        // then
        assertThat(orderDto.address()).isEqualTo(updateOrderRequestDto.address());
        assertThat(orderDto.postcode()).isEqualTo(updateOrderRequestDto.postcode());
    }
}