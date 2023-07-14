package com.ymkim.devbooks.order.domain.repository;

import com.ymkim.devbooks.order.domain.entity.Order;
import com.ymkim.devbooks.order.domain.entity.OrderItem;
import com.ymkim.devbooks.order.domain.entity.OrderStatus;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

import static com.ymkim.devbooks.global.util.JdbcUtils.toLocalDateTime;

@Repository
public class OrderJdbcRepository implements OrderRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public OrderJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Order save(Order order) {
        jdbcTemplate.update("INSERT INTO orders(order_id, address, postcode, created_at, order_status) " +
                "VALUES(:orderId, :address, :postcode, :createdAt, :orderStatus)", toOrderParamMap(order));

        order.getOrderItems().forEach(orderItem -> jdbcTemplate.update("INSERT INTO order_item(order_id, book_id, quantity) " +
                "VALUES(:orderId, :bookId, :quantity)", toOrderItemParamMap(orderItem)));
        return order;
    }

    @Override
    public void deleteAll() {
        jdbcTemplate.update("DELETE FROM orders", Collections.emptyMap());
    }

    @Override
    public Optional<Order> findById(String orderId) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT * FROM orders WHERE order_id = :orderId",
                Collections.singletonMap("orderId", orderId),
                orderRowMapper));
    }

    @Override
    public List<Order> findAll() {
        return jdbcTemplate.query("SELECT * FROM orders", orderRowMapper);
    }

    private Map<String, Object> toOrderParamMap(Order order) {
        var paramMap = new HashMap<String, Object>();
        paramMap.put("orderId", order.getOrderId());
        paramMap.put("address", order.getAddress());
        paramMap.put("postcode", order.getPostcode());
        paramMap.put("createdAt", order.getCreatedAt());
        paramMap.put("orderItems", order.getOrderItems());
        paramMap.put("orderStatus", order.getOrderStatus().toString());
        return paramMap;
    }

    private Map<String, Object> toOrderItemParamMap(OrderItem orderItem) {
        var paramMap = new HashMap<String, Object>();
        paramMap.put("orderId", orderItem.getOrderId());
        paramMap.put("bookId", orderItem.getBookId());
        paramMap.put("quantity", orderItem.getQuantity());
        return paramMap;
    }

    private final RowMapper<Order> orderRowMapper = (resulSet, rowNum) -> {
        var orderId = resulSet.getString("order_id");
        var address = resulSet.getString("address");
        var postcode = resulSet.getString("postcode");
        var createdAt = toLocalDateTime(resulSet.getTimestamp("created_at"));
        var orderStatus = resulSet.getString("order_status");
        return new Order(orderId, address, postcode, createdAt, OrderStatus.valueOf(orderStatus));
    };
}
