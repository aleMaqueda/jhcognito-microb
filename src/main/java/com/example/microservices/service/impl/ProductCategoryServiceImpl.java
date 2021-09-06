package com.example.microservices.service.impl;

import com.example.microservices.service.ProductCategoryService;
import com.example.microservices.domain.ProductCategory;
import com.example.microservices.repository.ProductCategoryRepository;
import com.example.microservices.service.dto.ProductCategoryDTO;
import com.example.microservices.service.mapper.ProductCategoryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link ProductCategory}.
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final Logger log = LoggerFactory.getLogger(ProductCategoryServiceImpl.class);

    private final ProductCategoryRepository productCategoryRepository;

    private final ProductCategoryMapper productCategoryMapper;

    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository, ProductCategoryMapper productCategoryMapper) {
        this.productCategoryRepository = productCategoryRepository;
        this.productCategoryMapper = productCategoryMapper;
    }

    @Override
    public ProductCategoryDTO save(ProductCategoryDTO productCategoryDTO) {
        log.debug("Request to save ProductCategory : {}", productCategoryDTO);
        ProductCategory productCategory = productCategoryMapper.toEntity(productCategoryDTO);
        productCategory = productCategoryRepository.save(productCategory);
        return productCategoryMapper.toDto(productCategory);
    }

    @Override
    public List<ProductCategoryDTO> findAll() {
        log.debug("Request to get all ProductCategories");
        return productCategoryRepository.findAll().stream()
            .map(productCategoryMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    @Override
    public Optional<ProductCategoryDTO> findOne(String id) {
        log.debug("Request to get ProductCategory : {}", id);
        return productCategoryRepository.findById(id)
            .map(productCategoryMapper::toDto);
    }

    @Override
    public void delete(String id) {
        log.debug("Request to delete ProductCategory : {}", id);
        productCategoryRepository.deleteById(id);
    }
}
