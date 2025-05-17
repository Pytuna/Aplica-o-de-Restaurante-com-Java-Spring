package com.example.demo.mapper;

import com.example.demo.dto.SubscriptionTypeDto;
import com.example.demo.model.SubscriptionsType;

public class SubscriptionTypeMapper {
    public static SubscriptionsType fromDtoToEntity(SubscriptionTypeDto dto) {
        return SubscriptionsType.builder()
                .id(dto.getId())
                .name(dto.getName())
                .accessMonths(dto.getAccessMonths())
                .price(dto.getPrice())
                .productKey(dto.getProductKey())
                .build();
    };
}
