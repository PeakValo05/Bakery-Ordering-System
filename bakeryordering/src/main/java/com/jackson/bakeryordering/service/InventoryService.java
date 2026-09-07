package com.jackson.bakeryordering.service;

import org.springframework.stereotype.Service;

import com.jackson.bakeryordering.model.InventoryModel;
import com.jackson.bakeryordering.repository.InventoryRepository;


@Service    
public class InventoryService {


    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Iterable<InventoryModel> getAllInventory() {
        return inventoryRepository.findAll();
    }

    public void saveProduct(InventoryModel product) {
        inventoryRepository.save(product);
    }

    public InventoryModel getProductById(Long id) {
        return inventoryRepository.findById(id).orElse(null);
    }
    public void deleteProduct(Long id) {
        inventoryRepository.deleteById(id);
    }

}
