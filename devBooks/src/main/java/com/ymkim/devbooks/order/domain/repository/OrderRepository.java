package com.ymkim.devbooks.order.domain.repository;

import com.ymkim.devbooks.order.domain.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    Order save(Order order);
    void deleteAll();
    Optional<Order> findById(long orderId);
}
