package com.ymkim.devbooks.order.controller.api;

import com.ymkim.devbooks.order.domain.dto.OrderDto;
import com.ymkim.devbooks.order.domain.dto.request.CreateOrderRequestDto;
import com.ymkim.devbooks.order.domain.dto.request.UpdateOrderRequestDto;
import com.ymkim.devbooks.order.item.domain.dto.OrderItemDto;
import com.ymkim.devbooks.order.item.domain.dto.request.CreateOrderItemRequestDto;
import com.ymkim.devbooks.order.item.service.OrderItemService;
import com.ymkim.devbooks.order.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderRestController {

    private final OrderService orderService;
    private final OrderItemService orderItemService;

    @PostMapping
    public ResponseEntity<Long> createOrder(@Valid @RequestBody CreateOrderRequestDto createOrderRequestDto) {
        log.info(createOrderRequestDto.address());
        Long orderId = orderService.createOrder(createOrderRequestDto);
        List<CreateOrderItemRequestDto> createOrderItemDtos = createOrderRequestDto.orderItems();

        for (CreateOrderItemRequestDto createItemDto : createOrderItemDtos) {
            OrderItemDto itemDto = new OrderItemDto(orderId, createItemDto.bookId(), createItemDto.quantity());
            orderItemService.createOrderItem(itemDto);
        }
        return ResponseEntity.ok().body(orderId);
    }

    @PutMapping
    public ResponseEntity<OrderDto> updateOrder(@Valid @RequestBody UpdateOrderRequestDto updateOrderRequestDto) {
        OrderDto orderDto = orderService.updateOrder(updateOrderRequestDto);
        return ResponseEntity.ok().body(orderDto);
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getOrders() {
        List<OrderDto> orders = orderService.getAllOrders();
        return ResponseEntity.ok().body(orders);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok().body("Order Deleted Successfully!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable("id") long id) {
        Optional<OrderDto> order = orderService.findOrder(id);
        return order.map(orderDto -> ResponseEntity.ok()
                .body(orderDto)).orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
