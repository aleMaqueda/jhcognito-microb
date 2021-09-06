package com.example.microservices.service.mapper;


import com.example.microservices.domain.*;
import com.example.microservices.service.dto.ProductCategoryDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ProductCategory} and its DTO {@link ProductCategoryDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ProductCategoryMapper extends EntityMapper<ProductCategoryDTO, ProductCategory> {


    @Mapping(target = "products", ignore = true)
    @Mapping(target = "removeProduct", ignore = true)
    ProductCategory toEntity(ProductCategoryDTO productCategoryDTO);

    default ProductCategory fromId(String id) {
        if (id == null) {
            return null;
        }
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(id);
        return productCategory;
    }
}
