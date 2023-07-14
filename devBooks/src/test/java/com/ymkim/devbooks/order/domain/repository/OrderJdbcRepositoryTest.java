package com.ymkim.devbooks.order.domain.repository;

import com.ymkim.devbooks.order.domain.entity.Order;
import com.ymkim.devbooks.order.domain.entity.OrderStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class OrderJdbcRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @AfterEach
    void clear() {
        orderRepository.deleteAll();
    }

    @Test
    @DisplayName("Order save test")
    void saveTest() {
        // given
        var order = new Order(UUID.randomUUID().toString(), "서울 송파구", "05123", LocalDateTime.now(), OrderStatus.ACCEPTED);

        // when
        orderRepository.save(order);
        var savedOrder = orderRepository.findById(order.getOrderId());

        // then
        assertThat(savedOrder).isNotEmpty();
        assertThat(savedOrder.get().getOrderId()).isEqualTo(order.getOrderId());
    }

    @Test
    @DisplayName("Order findAll test")
    void findAllTest() {
        // given
        var order1 = new Order(UUID.randomUUID().toString(), "서울 송파구", "05123", LocalDateTime.now(), OrderStatus.ACCEPTED);
        var order2 = new Order(UUID.randomUUID().toString(), "서울 강남구", "21323", LocalDateTime.now(), OrderStatus.SHIPPED);
        var order3 = new Order(UUID.randomUUID().toString(), "서울 성북구", "19523", LocalDateTime.now(), OrderStatus.READY_FOR_DELIVERY);

        // when
        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);
        List<Order> orders = orderRepository.findAll();

        // then
        assertThat(orders).hasSize(3);
    }
}