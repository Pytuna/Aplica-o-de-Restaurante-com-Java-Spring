package com.example.demo.controller;

import com.example.demo.model.SubscriptionsType;
import com.example.demo.repository.SubscriptionsTypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/subscription-type")
public class SubscriptionTypeController {
    @Autowired
    private SubscriptionsTypeRepository subscriptionsTypeRepository;

    @GetMapping()
    public ResponseEntity <List<SubscriptionsType>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(subscriptionsTypeRepository.findAll());
    }
}
