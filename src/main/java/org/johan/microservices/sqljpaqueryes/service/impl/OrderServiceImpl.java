package org.johan.microservices.sqljpaqueryes.service.impl;


import org.johan.microservices.sqljpaqueryes.dto.request.OrderRequest;
import org.johan.microservices.sqljpaqueryes.dto.response.OrderResponse;
import org.johan.microservices.sqljpaqueryes.mapper.OrderMapper;
import org.johan.microservices.sqljpaqueryes.model.Order;
import org.johan.microservices.sqljpaqueryes.repository.OrderRepository;
import org.johan.microservices.sqljpaqueryes.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public void createOrder(OrderRequest orderRequest,
                            Long userId,
                            Long productId) {
        if (userId == null || productId == null) {
            throw new IllegalArgumentException("User Id and Product Id must not be null");
        }

    }

    @Override
    public List<OrderResponse> getAllOrders() {
        return List.of();
    }

    @Override
    public OrderResponse getOrderById(Long id) {
        return null;
    }

    @Override
    public List<OrderResponse> getOrdersByUserId(Long userId) {
        return List.of();
    }


    @Override
    public void deleteOrderById(Long id) {

    }

    @Override
    public void updateOrderStatus(Long id, String status) {

    }

    @Override
    public Double getTotalAmount(Long id) {
        return 0.0;
    }

    @Override
    public void addProductToOrder(Long orderId, Long productId) {

    }
}
