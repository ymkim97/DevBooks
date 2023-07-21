package com.ymkim.devbooks.order.service;

import com.ymkim.devbooks.global.ExceptionMessages;
import com.ymkim.devbooks.order.domain.dto.OrderDto;
import com.ymkim.devbooks.order.domain.dto.request.CreateOrderRequestDto;
import com.ymkim.devbooks.order.domain.dto.request.UpdateOrderRequestDto;
import com.ymkim.devbooks.order.domain.entity.Order;
import com.ymkim.devbooks.order.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public Long createOrder(CreateOrderRequestDto createOrderRequestDto) {
        Order savedOrder = orderRepository.save(createOrderRequestDto.toEntity());
        return orderRepository.save(savedOrder).getOrderId();
    }

    @Override
    public Optional<OrderDto> findOrder(long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.map(OrderDto::new);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return StreamSupport.stream(orderRepository.findAll().spliterator(), false)
                .map(OrderDto::new)
                .toList();
    }

    @Override
    @Transactional
    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }

    @Override
    @Transactional
    public OrderDto updateOrder(UpdateOrderRequestDto updateOrderRequestDto) {
        Order order = orderRepository.findById(updateOrderRequestDto.orderId())
                .orElseThrow(() -> new NoSuchElementException(ExceptionMessages.NO_ORDER_FOUND_BY_ID_ERROR.getMessage()));

        order.update(updateOrderRequestDto);
        orderRepository.save(order);
        return new OrderDto(order);
    }
}
