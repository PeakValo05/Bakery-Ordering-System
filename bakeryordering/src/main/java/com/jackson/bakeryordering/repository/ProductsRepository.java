package com.jackson.bakeryordering.repository;
import org.springframework.data.repository.CrudRepository;
    
import com.jackson.bakeryordering.model.ProductsModel;


public interface ProductsRepository
        extends CrudRepository<ProductsModel, Long> {
}