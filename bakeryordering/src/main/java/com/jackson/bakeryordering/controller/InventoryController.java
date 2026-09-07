package com.jackson.bakeryordering.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jackson.bakeryordering.service.InventoryService;
import com.jackson.bakeryordering.service.OrdersService;
import com.jackson.bakeryordering.service.ProductsService;
import com.jackson.bakeryordering.service.StaffService;



@Controller
public class InventoryController {

    private static final Logger logger =
            LoggerFactory.getLogger(InventoryController.class);

    private final InventoryService inventoryService;
    private final ProductsService productsService;
    private final StaffService staffService;
    private final OrdersService ordersService;

    public InventoryController(
            InventoryService inventoryService,
            ProductsService productsService,
            StaffService staffService,
            OrdersService ordersService) {

        this.inventoryService = inventoryService;
        this.productsService = productsService;
        this.staffService = staffService;
        this.ordersService = ordersService;
    }
@GetMapping("/inventory")
public String viewInventory(Model model) {

    logger.info("Entering viewInventory");

    model.addAttribute(
        "inventory",
        inventoryService.getAllInventory()
    );

    model.addAttribute(
        "products",
        productsService.getAllProducts()
    );

    model.addAttribute(
        "totalProducts",
        productsService.getTotalProducts()
    );
    model.addAttribute(
        "totalStaff",
        staffService.getTotalStaff()
    );  
    model.addAttribute(
        "totalOrders",
        ordersService.getTotalOrders()
    );

    logger.info("Exiting viewInventory");

    return "inventory";
}
}