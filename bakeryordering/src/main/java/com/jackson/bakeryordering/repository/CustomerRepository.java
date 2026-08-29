package com.jackson.bakeryordering.repository;

import org.springframework.data.repository.CrudRepository;

import com.jackson.bakeryordering.model.CustomerModel;

public interface CustomerRepository extends CrudRepository<CustomerModel, Long> {
    
}
