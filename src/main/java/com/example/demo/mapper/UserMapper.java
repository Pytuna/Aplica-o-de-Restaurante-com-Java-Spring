package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.model.SubscriptionsType;
import com.example.demo.model.UserType;
import com.example.demo.model.Users;

public class UserMapper {
    public static Users fromDtoToEntity(UserDto dto, UserType userType, SubscriptionsType subscriptionsType){
        return Users.builder()
        .id(dto.getId())
        .name(dto.getName())
        .cpf(dto.getCpf())
        .email(dto.getEmail())
        .phone(dto.getPhone())
        .dtSubscription(dto.getDtSubscription())
        .dtExpiration(dto.getDtExpiration())
        .userType(userType)
        .subscriptionsType(subscriptionsType)
        .build();
    }
}
