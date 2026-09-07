package com.jackson.bakeryordering.service;

import org.springframework.stereotype.Service;

import com.jackson.bakeryordering.model.ProductsModel;
import com.jackson.bakeryordering.repository.ProductsRepository;


@Service    
public class ProductsService {


    private final ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public Iterable<ProductsModel> getAllProducts() {
        return productsRepository.findAll();
    }

    public void saveProduct(ProductsModel product) {
        productsRepository.save(product);
    }

    public ProductsModel getProductById(Long id) {
        return productsRepository.findById(id).orElse(null);
    }
    public void deleteProduct(Long id) {
        productsRepository.deleteById(id);
    }

public long getTotalProducts() {
    return productsRepository.count();
}
}
