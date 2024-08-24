package org.johan.microservices.sqljpaqueryes.service;

import org.johan.microservices.sqljpaqueryes.dto.request.OrderRequest;
import org.johan.microservices.sqljpaqueryes.dto.response.OrderResponse;

import java.util.List;

public interface OrderService {
    void createOrder(OrderRequest orderRequest, Long userId, Long productId);

    List<OrderResponse> getAllOrders();

    OrderResponse getOrderById(Long id);

    List<OrderResponse> getOrdersByUserId(Long userId);

//    List<OrderResponse> getOrdersByProductId(Long productId);

    void deleteOrderById(Long id);

    void updateOrderStatus(Long id, String status);

    Double getTotalAmount(Long id);

    void addProductToOrder(Long orderId, Long productId);


}
