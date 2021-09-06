package com.example.microservices.service.impl;

import com.example.microservices.service.OrderItemService;
import com.example.microservices.domain.OrderItem;
import com.example.microservices.repository.OrderItemRepository;
import com.example.microservices.service.dto.OrderItemDTO;
import com.example.microservices.service.mapper.OrderItemMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing {@link OrderItem}.
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final Logger log = LoggerFactory.getLogger(OrderItemServiceImpl.class);

    private final OrderItemRepository orderItemRepository;

    private final OrderItemMapper orderItemMapper;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository, OrderItemMapper orderItemMapper) {
        this.orderItemRepository = orderItemRepository;
        this.orderItemMapper = orderItemMapper;
    }

    @Override
    public OrderItemDTO save(OrderItemDTO orderItemDTO) {
        log.debug("Request to save OrderItem : {}", orderItemDTO);
        OrderItem orderItem = orderItemMapper.toEntity(orderItemDTO);
        orderItem = orderItemRepository.save(orderItem);
        return orderItemMapper.toDto(orderItem);
    }

    @Override
    public Page<OrderItemDTO> findAll(Pageable pageable) {
        log.debug("Request to get all OrderItems");
        return orderItemRepository.findAll(pageable)
            .map(orderItemMapper::toDto);
    }


    @Override
    public Optional<OrderItemDTO> findOne(String id) {
        log.debug("Request to get OrderItem : {}", id);
        return orderItemRepository.findById(id)
            .map(orderItemMapper::toDto);
    }

    @Override
    public void delete(String id) {
        log.debug("Request to delete OrderItem : {}", id);
        orderItemRepository.deleteById(id);
    }
}
