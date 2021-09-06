package com.example.microservices.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class OrderItemMapperTest {

    private OrderItemMapper orderItemMapper;

    @BeforeEach
    public void setUp() {
        orderItemMapper = new OrderItemMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        String id = "id1";
        assertThat(orderItemMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(orderItemMapper.fromId(null)).isNull();
    }
}
