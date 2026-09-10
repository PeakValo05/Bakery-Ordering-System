package com.jackson.bakeryordering.service;

import java.util.List;

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

    // Get all inventory items that are low in stock
    public List<InventoryModel> getLowStockItemsCount() {
        return inventoryRepository.findLowStockItems();
    }
    // Get the count of low stock items
    public long getLowStockItemCount() {
        return inventoryRepository.findLowStockItems().size();
    }

    // Get a product by its id
    public InventoryModel getProductById(Long id) {
        return inventoryRepository.findById(id).orElse(null);
    }
    public void deleteProduct(Long id) {
        inventoryRepository.deleteById(id);
    }

}
