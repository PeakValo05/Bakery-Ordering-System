package com.jackson.bakeryordering.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productsService.deleteProduct(id);
        return "redirect:/products";
    }


    @GetMapping("/products/edit/{id}")
    public String displayEditProduct(@PathVariable("id") Long id, Model model) {
        ProductsModel product = productsService.getProductById(id);
        model.addAttribute("product", product);
        return "edit-products";
    }


    @PostMapping("/products/update")
    public String editProduct(
            @ModelAttribute("product") ProductsModel product) {

        System.out.println("Entering editProduct");

        productsService.saveProduct(product);

        System.out.println("Product updated successfully");
        return "redirect:/products";
    }
}
