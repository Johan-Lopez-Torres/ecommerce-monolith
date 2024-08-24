package org.johan.microservices.sqljpaqueryes.service;

import org.johan.microservices.sqljpaqueryes.dto.request.UserRequest;
import org.johan.microservices.sqljpaqueryes.dto.response.UserResponse;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;

@Repository
public interface UserService {


    void createUser(UserRequest userRequest);

    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long id);

    void deleteUserById(Long id);

    void updateUserById(Long id, UserRequest userRequest);


}

