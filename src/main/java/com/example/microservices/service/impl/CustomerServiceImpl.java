package com.example.microservices.service.impl;

import com.example.microservices.service.CustomerService;
import com.example.microservices.domain.Customer;
import com.example.microservices.repository.CustomerRepository;
import com.example.microservices.service.dto.CustomerDTO;
import com.example.microservices.service.mapper.CustomerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Customer}.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        log.debug("Request to save Customer : {}", customerDTO);
        Customer customer = customerMapper.toEntity(customerDTO);
        customer = customerRepository.save(customer);
        return customerMapper.toDto(customer);
    }

    @Override
    public Page<CustomerDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Customers");
        return customerRepository.findAll(pageable)
            .map(customerMapper::toDto);
    }


    @Override
    public Optional<CustomerDTO> findOne(String id) {
        log.debug("Request to get Customer : {}", id);
        return customerRepository.findById(id)
            .map(customerMapper::toDto);
    }

    @Override
    public void delete(String id) {
        log.debug("Request to delete Customer : {}", id);
        customerRepository.deleteById(id);
    }
}
