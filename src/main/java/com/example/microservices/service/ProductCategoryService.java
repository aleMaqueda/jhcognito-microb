package com.example.microservices.service;

import com.example.microservices.service.dto.ProductCategoryDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.example.microservices.domain.ProductCategory}.
 */
public interface ProductCategoryService {

    /**
     * Save a productCategory.
     *
     * @param productCategoryDTO the entity to save.
     * @return the persisted entity.
     */
    ProductCategoryDTO save(ProductCategoryDTO productCategoryDTO);

    /**
     * Get all the productCategories.
     *
     * @return the list of entities.
     */
    List<ProductCategoryDTO> findAll();


    /**
     * Get the "id" productCategory.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ProductCategoryDTO> findOne(String id);

    /**
     * Delete the "id" productCategory.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
