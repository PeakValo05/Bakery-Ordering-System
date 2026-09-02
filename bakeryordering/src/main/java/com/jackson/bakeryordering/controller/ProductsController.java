package com.jackson.bakeryordering.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jackson.bakeryordering.model.ProductsModel;
import com.jackson.bakeryordering.service.ProductsService;

@Controller
public class ProductsController {

    private final ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        model.addAttribute(
                "products",
                productsService.getAllProducts()
        );

        return "products";
    }

    @GetMapping("/products/add")
    public String displayAddProduct(Model model) {
        model.addAttribute("product", new ProductsModel());
        return "add-product";
    }

    @PostMapping("/products/save")
    public String saveProduct(
            @ModelAttribute("product") ProductsModel product) {

        productsService.saveProduct(product);
        return "redirect:/products";
    }
}