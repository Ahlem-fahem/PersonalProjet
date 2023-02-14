package com.example.worldtour.service;

import com.example.worldtour.dto.UserDto;
import com.example.worldtour.entity.User;

import java.util.List;

public interface UserService {
    UserDto saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}