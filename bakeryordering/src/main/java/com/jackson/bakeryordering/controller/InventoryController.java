package com.jackson.bakeryordering.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jackson.bakeryordering.model.InventoryModel;
import com.jackson.bakeryordering.model.ProductsModel;
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








// View inventory page
@GetMapping("/inventory")
public String viewInventory(Model model) {

    logger.info("Entering InventoryController.viewInventory");

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

    model.addAttribute(
        "lowStockCount",
        inventoryService.getLowStockItemCount()
    );

    logger.info("Exiting InventoryController.viewInventory");

    return "inventory";
}









@GetMapping("/inventory/add")
public String displayAddInventoryItem(Model model) {

    InventoryModel inventoryItem = new InventoryModel();

    model.addAttribute("inventoryItem", inventoryItem);
    model.addAttribute("products", productsService.getAllProducts());
    model.addAttribute("staff", staffService.getAllStaff());

    return "add-inv-item";
}









// Search products in inventory
@GetMapping("/inventory/search")
public String searchProducts(


        @RequestParam("searchTerm") String searchTerm,
        Model model) {

    logger.info("Entering InventoryController.searchProducts with searchTerm: {}", searchTerm);

    model.addAttribute(
        "searchResults",
        productsService.searchProducts(searchTerm)
    );

    model.addAttribute(
        "inventory",
        inventoryService.getAllInventory()
    );

    model.addAttribute(
        "totalProducts",
        productsService.getTotalProducts()
    );

    logger.info("Exiting InventoryController.searchProducts");

    return "inventory";
}







@GetMapping("/inventory/search-products")
@ResponseBody

    
public List<ProductsModel> searchProducts(
        @RequestParam("searchTerm") String searchTerm) {

    logger.info("Entering InventoryController.searchProducts (AJAX) with searchTerm: {}", searchTerm);

    logger.info("Exiting InventoryController.searchProducts (AJAX)");

    return productsService.searchProducts(searchTerm);
}
}