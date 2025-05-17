package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.SubscriptionTypeDto;
import com.example.demo.model.SubscriptionsType;

public interface SubscriptionTypeService {
    List<SubscriptionsType> findAll();
    SubscriptionsType findById(Long id);
    SubscriptionsType create(SubscriptionTypeDto dto);
    SubscriptionsType update(Long id, SubscriptionTypeDto dto);
    void delete(Long id);
}
