package org.johan.microservices.sqljpaqueryes.service.impl;

import org.johan.microservices.sqljpaqueryes.dto.request.UserRequest;
import org.johan.microservices.sqljpaqueryes.dto.response.UserResponse;
import org.johan.microservices.sqljpaqueryes.exception.UserAlreadyExistsException;
import org.johan.microservices.sqljpaqueryes.exception.UserNotFoundException;
import org.johan.microservices.sqljpaqueryes.mapper.UserMapper;
import org.johan.microservices.sqljpaqueryes.model.User;
import org.johan.microservices.sqljpaqueryes.repository.UserRepository;
import org.johan.microservices.sqljpaqueryes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void createUser(UserRequest userRequest) {
        if (userRepository.existsByEmail(userRequest.getEmail())) {
            throw new UserAlreadyExistsException(userRequest.getEmail());
        }
        User user = userMapper.userRequestToUser(userRequest);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        userRepository.save(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::userToUserResponse)
                .toList();
    }

    @Override
    public UserResponse getUserById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id.toString());
        } else {
            User user = userRepository.findById(id).get();
            return userMapper.userToUserResponse(user);
        }
    }

    @Override
    public void deleteUserById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new UserNotFoundException(id.toString());
        }
    }

    @Override
    public void updateUserById(Long id, @RequestBody UserRequest userRequest) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id.toString());
        } else {
            User user = userMapper.userRequestToUser(userRequest);
            user.setId(id);
            userRepository.save(user);
        }
    }
}
