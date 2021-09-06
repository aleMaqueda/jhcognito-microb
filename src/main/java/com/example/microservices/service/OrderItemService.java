package com.example.microservices.service;

import com.example.microservices.service.dto.OrderItemDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.example.microservices.domain.OrderItem}.
 */
public interface OrderItemService {

    /**
     * Save a orderItem.
     *
     * @param orderItemDTO the entity to save.
     * @return the persisted entity.
     */
    OrderItemDTO save(OrderItemDTO orderItemDTO);

    /**
     * Get all the orderItems.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<OrderItemDTO> findAll(Pageable pageable);


    /**
     * Get the "id" orderItem.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<OrderItemDTO> findOne(String id);

    /**
     * Delete the "id" orderItem.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
