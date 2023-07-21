package com.ymkim.devbooks.order.service;

import com.ymkim.devbooks.order.domain.dto.OrderDto;
import com.ymkim.devbooks.order.domain.dto.request.CreateOrderRequestDto;
import com.ymkim.devbooks.order.domain.dto.request.UpdateOrderRequestDto;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Long createOrder(CreateOrderRequestDto createOrderRequestDto);

    Optional<OrderDto> findOrder(long id);

    List<OrderDto> getAllOrders();

    void deleteOrder(long id);

    OrderDto updateOrder(UpdateOrderRequestDto updateOrderRequestDto);
}
