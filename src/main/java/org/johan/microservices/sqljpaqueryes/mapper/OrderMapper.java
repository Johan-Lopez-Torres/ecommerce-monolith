package org.johan.microservices.sqljpaqueryes.mapper;


import org.johan.microservices.sqljpaqueryes.dto.request.OrderRequest;
import org.johan.microservices.sqljpaqueryes.dto.response.OrderResponse;
import org.johan.microservices.sqljpaqueryes.exception.UserNotFoundException;
import org.johan.microservices.sqljpaqueryes.model.Order;
import org.johan.microservices.sqljpaqueryes.model.User;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public static final OrderMapper INSTANCE = new OrderMapper();

    OrderResponse orderToOrderResponse(Order order) {
        try {
            if (order == null) {
                throw new UserNotFoundException("Order not found");
            }

            return OrderResponse.builder()
                    .id(order.getId())
                    .name(order.getName())
                    .description(order.getDescription())
                    .trackingNumber(order.getTrackingNumber())
                    .shippingAddress(order.getShippingAddress())
                    .shippingCity(order.getShippingCity())
                    .shippingState(order.getShippingState())
                    .status(order.getStatus())
                    .createdAt(order.getCreatedAt())
                    .updatedAt(order.getUpdatedAt())
                    .deletedAt(order.getDeletedAt())
                    .build();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    Order orderRequestToOrder(OrderRequest orderRequest) {
        return Order.builder()
                .name(orderRequest.getName())
                .description(orderRequest.getDescription())
                .trackingNumber(orderRequest.getTrackingNumber())
                .shippingAddress(orderRequest.getShippingAddress())
                .shippingCity(orderRequest.getShippingCity())
                .shippingState(orderRequest.getShippingState())
                .status(orderRequest.getStatus())
                .productId(orderRequest.getProducts())
                .build();
    }


}
