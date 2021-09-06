package com.example.microservices.repository;

import com.example.microservices.domain.OrderItem;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the OrderItem entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OrderItemRepository extends MongoRepository<OrderItem, String> {
}
