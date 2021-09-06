package com.example.microservices.service.mapper;


import com.example.microservices.domain.*;
import com.example.microservices.service.dto.ProductDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Product} and its DTO {@link ProductDTO}.
 */
@Mapper(componentModel = "spring", uses = {ProductCategoryMapper.class})
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {

    @Mapping(source = "productCategory.id", target = "productCategoryId")
    @Mapping(source = "productCategory.name", target = "productCategoryName")
    ProductDTO toDto(Product product);

    @Mapping(source = "productCategoryId", target = "productCategory")
    Product toEntity(ProductDTO productDTO);

    default Product fromId(String id) {
        if (id == null) {
            return null;
        }
        Product product = new Product();
        product.setId(id);
        return product;
    }
}
