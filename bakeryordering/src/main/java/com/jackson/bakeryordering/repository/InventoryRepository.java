package com.jackson.bakeryordering.repository;

import org.springframework.data.repository.CrudRepository;

import com.jackson.bakeryordering.model.InventoryModel;

public interface InventoryRepository extends CrudRepository<InventoryModel, Long> {
    
}
