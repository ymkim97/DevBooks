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
import java.util.Collections;

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
        var order = new Order("서울 송파구", "05123", LocalDateTime.now(), Collections.emptyList(), OrderStatus.ACCEPTED);

        // when
        orderRepository.save(order);
        var savedOrder = orderRepository.findById(order.getOrderId());

        // then
        assertThat(savedOrder).isNotEmpty();
        assertThat(savedOrder.get().getOrderId()).isEqualTo(order.getOrderId());
    }
}