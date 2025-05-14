package com.example.demo.repository;

import com.example.demo.model.SubscriptionsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;;

@Repository
public interface SubscriptionsTypeRepository extends JpaRepository<SubscriptionsType, Long> {
}