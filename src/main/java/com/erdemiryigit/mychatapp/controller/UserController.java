package com.erdemiryigit.mychatapp.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erdemiryigit.mychatapp.model.request.UserRequest;
import com.erdemiryigit.mychatapp.model.response.UserResponse;
import com.erdemiryigit.mychatapp.service.UserService;
import com.erdemiryigit.mychatapp.shared.UserDto;

@RestController
@RequestMapping("/users") 
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/test")
    public String getUser() {
        return "getUser was called";
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        UserResponse response = new UserResponse();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userRequest, userDto);

        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, response);

        return response;
    }

    @PutMapping
    public String updateUser(@RequestBody UserRequest userRequest) {
        return "updateUser was called";
    }

    @DeleteMapping
    public String deleteUser(@PathVariable String id) {
        return "deleteUser was called with id: " + id;
    }

}
