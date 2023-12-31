package com.ymkim.devbooks.order.item.domain.repository;

import com.ymkim.devbooks.order.item.domain.entity.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemJdbcRepository extends CrudRepository<OrderItem, Long>, OrderItemJdbcRepositoryCustom {
}
