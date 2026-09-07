package com.jackson.bakeryordering.repository;
import java.util.List;
    
import org.springframework.data.repository.CrudRepository;

import com.jackson.bakeryordering.model.ProductsModel;


public interface ProductsRepository
        extends CrudRepository<ProductsModel, Long> {



List<ProductsModel> findByProductNameContainingIgnoreCase(String productName);
}