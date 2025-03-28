package com.nam.migi_service.controller;

import com.nam.migi_service.dto.request.ApiResponse;
import com.nam.migi_service.dto.request.UserCreationRequest;
import com.nam.migi_service.dto.request.UserUpdateRequest;
import com.nam.migi_service.entity.User;
import com.nam.migi_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();

        apiResponse.setResult(userService.createRequest(request));
        return apiResponse;
    }

    @GetMapping
    List<User> getAllUsers() {
        return userService.getAllUser();
    }

    @GetMapping("/{userId}")
    User getUserById(@PathVariable("userId") String userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        boolean rs = userService.deleteUser(userId);
        if (rs) {
            return "User deleted";
        } else {
            return "User could not be deleted";
        }

    }

}
