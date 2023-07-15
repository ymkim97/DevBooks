package com.ymkim.devbooks.order.domain.repository;

import com.ymkim.devbooks.order.domain.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
