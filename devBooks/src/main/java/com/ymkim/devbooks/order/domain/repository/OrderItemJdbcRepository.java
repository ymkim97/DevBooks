package com.ymkim.devbooks.order.domain.repository;

import com.ymkim.devbooks.order.domain.entity.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemJdbcRepository extends CrudRepository<OrderItem, Long> {
}
