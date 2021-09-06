package com.example.microservices.service.mapper;


import com.example.microservices.domain.*;
import com.example.microservices.service.dto.OrderItemDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link OrderItem} and its DTO {@link OrderItemDTO}.
 */
@Mapper(componentModel = "spring", uses = {ProductMapper.class, ProductOrderMapper.class})
public interface OrderItemMapper extends EntityMapper<OrderItemDTO, OrderItem> {

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.name", target = "productName")
    @Mapping(source = "order.id", target = "orderId")
    @Mapping(source = "order.code", target = "orderCode")
    OrderItemDTO toDto(OrderItem orderItem);

    @Mapping(source = "productId", target = "product")
    @Mapping(source = "orderId", target = "order")
    OrderItem toEntity(OrderItemDTO orderItemDTO);

    default OrderItem fromId(String id) {
        if (id == null) {
            return null;
        }
        OrderItem orderItem = new OrderItem();
        orderItem.setId(id);
        return orderItem;
    }
}
