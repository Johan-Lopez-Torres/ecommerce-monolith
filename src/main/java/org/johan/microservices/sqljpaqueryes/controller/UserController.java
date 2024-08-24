package org.johan.microservices.sqljpaqueryes.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.johan.microservices.sqljpaqueryes.dto.request.UserRequest;
import org.johan.microservices.sqljpaqueryes.dto.response.UserResponse;
import org.johan.microservices.sqljpaqueryes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserRequest userRequest,
                                        BindingResult bindingResult) {
        Map<String, String> allError;
        if (bindingResult.hasErrors()) {
            allError = validate(bindingResult);
            return ResponseEntity.badRequest().body(allError);
        }
        userService.createUser(userRequest);
        return ResponseEntity.ok("User created successfully");
    }


    @GetMapping("/get-user/{}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        UserResponse userResponse = userService.getUserById(id);
        return ResponseEntity.status(201).body(userResponse);
    }

    @DeleteMapping("/delete-user")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.status(201).body("User deleted successfully");
    }

    @PutMapping("/update-user")
    public ResponseEntity<?> updateUser(Long id,
                                        @RequestBody UserRequest userRequest,
                                        BindingResult bindingResult) {
        Map<String, String> allErrors;
        if (bindingResult.hasErrors()) {
            allErrors = validate(bindingResult);
            return ResponseEntity.badRequest().body(allErrors);
        }
        userService.updateUserById(id, userRequest);
        return ResponseEntity.status(201).body("User updated successfully");
    }


    // take this method to the utils folder
    private Map<String, String> validate(BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(
                    fieldError -> errors.put(fieldError.getField(), fieldError.getDefaultMessage())
            );
        }
        return errors;
    }
}
