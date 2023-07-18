package com.ymkim.devbooks.order.item.service;

import com.ymkim.devbooks.order.item.domain.repository.OrderItemJdbcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemJdbcRepository orderItemRepository;


}
