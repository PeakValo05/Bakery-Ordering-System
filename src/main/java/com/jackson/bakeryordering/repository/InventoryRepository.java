package com.jackson.bakeryordering.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jackson.bakeryordering.model.InventoryModel;

public interface InventoryRepository extends CrudRepository<InventoryModel, Long> {
    

    @Query("SELECT i FROM InventoryModel i WHERE i.quantity <= i.reorderLevel")
    List<InventoryModel> findLowStockItems();
}
