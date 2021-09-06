package com.example.microservices.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductOrderMapperTest {

    private ProductOrderMapper productOrderMapper;

    @BeforeEach
    public void setUp() {
        productOrderMapper = new ProductOrderMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        String id = "id1";
        assertThat(productOrderMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(productOrderMapper.fromId(null)).isNull();
    }
}
