package com.erdemiryigit.mychatapp.service;

import org.springframework.stereotype.Service;

import com.erdemiryigit.mychatapp.shared.UserDto;

@Service
public interface UserService {
    UserDto createUser(UserDto userDto);
}
