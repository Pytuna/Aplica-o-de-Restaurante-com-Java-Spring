package com.example.demo.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import com.example.demo.exception.BadRequestException;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;
import com.example.demo.controller.SubscriptionTypeController;
import com.example.demo.dto.SubscriptionTypeDto;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.SubscriptionTypeMapper;
import com.example.demo.model.SubscriptionsType;
import com.example.demo.repository.SubscriptionsTypeRepository;
import com.example.demo.service.SubscriptionTypeService;

@Service
public class SubscriptionTypeServiceImpl implements SubscriptionTypeService {
    private final SubscriptionsTypeRepository subscriptionsTypeRepository;

    public SubscriptionTypeServiceImpl(SubscriptionsTypeRepository subscriptionsTypeRepository) {
        this.subscriptionsTypeRepository = subscriptionsTypeRepository;
    }

    @Override
    public SubscriptionsType create(SubscriptionTypeDto dto) {
        if (Objects.nonNull(dto.getId())) {
            throw new BadRequestException("Id deve ser nulo");
        }
        return subscriptionsTypeRepository.save(SubscriptionTypeMapper.fromDtoToEntity(dto));
    }

    @Override
    public void delete(Long id) {
        getOptionalSubscriptionsType(id);
        subscriptionsTypeRepository.deleteById(id);
    }

    @Override
    public List<SubscriptionsType> findAll() {
        return subscriptionsTypeRepository.findAll();
    }

    @Override
    public SubscriptionsType findById(Long id) {
        return getOptionalSubscriptionsType(id).add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(SubscriptionTypeController.class).findById(id)).withSelfRel());
    }

    @Override
    public SubscriptionsType update(Long id, SubscriptionTypeDto dto) {
        getOptionalSubscriptionsType(id);
        dto.setId(id);
        return subscriptionsTypeRepository.save(SubscriptionTypeMapper.fromDtoToEntity(dto));
    }

    private SubscriptionsType getOptionalSubscriptionsType(Long id) {
        Optional<SubscriptionsType> optionalSubscriptionsType = subscriptionsTypeRepository.findById(id);
        if (optionalSubscriptionsType.isEmpty()) {
            throw new NotFoundException("Item não encontrado");
        }
        return optionalSubscriptionsType.get();
    }
}
