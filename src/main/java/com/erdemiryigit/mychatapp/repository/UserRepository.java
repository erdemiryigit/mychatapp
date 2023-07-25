package com.erdemiryigit.mychatapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.erdemiryigit.mychatapp.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}
