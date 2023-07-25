package com.erdemiryigit.mychatapp.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.erdemiryigit.mychatapp.entity.UserEntity;
import com.erdemiryigit.mychatapp.repository.UserRepository;
import com.erdemiryigit.mychatapp.service.UserService;
import com.erdemiryigit.mychatapp.shared.UserDto;
import com.erdemiryigit.mychatapp.shared.Utils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto createUser(UserDto userDto) {

        if (userRepository.findByEmail(userDto.getEmail()) != null) {
            throw new RuntimeException("Record already exists");
        }

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity);

        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        String userId = utils.generateUserId(30);
        userEntity.setUserId(userId);

        UserEntity savedUser = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(savedUser, returnValue);

        return returnValue;
    }

}
