package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.Users;

public interface UserService {
    Users create(UserDto dto);
}
