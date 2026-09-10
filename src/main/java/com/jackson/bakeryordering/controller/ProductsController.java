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
        System.out.println("Entering ProductsController.getAllProducts");
        model.addAttribute(
                "products",
                productsService.getAllProducts()
        );

        System.out.println("Exiting ProductsController.getAllProducts");
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

        System.out.println("Entering ProductsController.saveProduct");

        productsService.saveProduct(product);

        System.out.println("Exiting ProductsController.saveProduct");

        return "redirect:/products";
    }





    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {

        System.out.println("Entering ProductsController.deleteProduct with id: " + id);

        productsService.deleteProduct(id);

        System.out.println("Exiting ProductsController.deleteProduct with id: " + id);
        return "redirect:/products";
    }






    @GetMapping("/products/edit/{id}")
    public String displayEditProduct(@PathVariable("id") Long id, Model model) {

        ProductsModel product = productsService.getProductById(id);

        model.addAttribute("product", product);

        System.out.println("Exiting ProductsController.displayEditProduct with id: " + id);
        return "edit-products";
    }






    @PostMapping("/products/update")
    public String editProduct(
            @ModelAttribute("product") ProductsModel product) {

        System.out.println("Entering ProductsController.editProduct with id: " + product.getProductsId());

        productsService.saveProduct(product);

        System.out.println("Exiting ProductsController.editProduct with id: " + product.getProductsId());
        return "redirect:/products";
    }
}
