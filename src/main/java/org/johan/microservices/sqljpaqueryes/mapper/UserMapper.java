package org.johan.microservices.sqljpaqueryes.mapper;


import lombok.Getter;
import lombok.Setter;
import org.johan.microservices.sqljpaqueryes.dto.request.UserRequest;
import org.johan.microservices.sqljpaqueryes.dto.response.UserResponse;
import org.johan.microservices.sqljpaqueryes.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@Getter
@Setter
public class UserMapper {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserResponse userToUserResponse(User user) {

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .address(user.getAddress())
                .city(user.getCity())
                .state(user.getState())
                .country(user.getCountry())
                .status(user.getStatus())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .deletedAt(user.getDeletedAt())
                .orderCount(user.getOrders().size())
                .orders(user
                        .getOrders()
                        .stream()
                        .map(OrderMapper.INSTANCE::orderToOrderResponse)
                        .collect(Collectors.toSet()))
                .build();
    }

    public User userRequestToUser(UserRequest userRequest) {
        return User.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .address(userRequest.getAddress())
                .city(userRequest.getCity())
                .state(userRequest.getState())
                .country(userRequest.getCountry())
                .status(userRequest.getStatus())
                .build();
    }

}
