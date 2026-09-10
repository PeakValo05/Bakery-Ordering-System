package com.jackson.bakeryordering.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jackson.bakeryordering.model.CustomerModel;
import com.jackson.bakeryordering.model.OrdersModel;
import com.jackson.bakeryordering.service.CustomerService;
import com.jackson.bakeryordering.service.OrdersService;




// Controller class for handling order-related requests
@Controller
public class OrderController {

    // Logger for logging messages
    private static final Logger logger =
            LoggerFactory.getLogger(OrderController.class);

    private final CustomerService customersService;
    private final OrdersService ordersService;

    public OrderController(CustomerService customersService, OrdersService ordersService) {
        this.customersService = customersService;
        this.ordersService = ordersService;
    }





    
    // Display the login page
    @GetMapping({"/", "/login"})
    public String displayLoginPage() {
        logger.info("Entering OrderController.displayLoginPage");
        logger.info("Exiting OrderController.displayLoginPage");
        return "login";
    }







// Display all orders
    @GetMapping("/orders")
    public String viewOrders(Model model) {
        logger.info("Entering OrderController.viewOrders");

        model.addAttribute("orders", ordersService.getAllOrders());

        logger.info("Exiting OrderController.viewOrders");
        return "orders";
    }







        // Display the add order page
@GetMapping("/orders/add")
public String displayAddOrder(Model model) {

    logger.info("Entering OrderController.displayAddOrder");

    OrdersModel order = new OrdersModel();
    order.setCustomer(new CustomerModel());

    model.addAttribute("order", order);
    model.addAttribute("customers", customersService.getAllCustomers());

    logger.info("Exiting OrderController.displayAddOrder");
    return "add-order";
}







// Save the order
@PostMapping("/orders/save")
public String saveOrder(
        @ModelAttribute("order") OrdersModel order) {

    logger.info("Entering OrderController.saveOrder with customerId: {}", order.getCustomer().getCustomerId());

    Long customerId = order.getCustomer().getCustomerId();
    CustomerModel customer =
            customersService.getCustomerById(customerId);

    if (customer == null) {

        return "redirect:/orders/add";
    }

    order.setCustomer(customer);

    ordersService.saveOrder(order);

    logger.info("Exiting OrderController.saveOrder with customerId: {}", order.getCustomer().getCustomerId());

    return "redirect:/orders";
}







// Display the edit order page
@GetMapping("/orders/edit/{id}")
public String displayEditOrderPage(@PathVariable("id") Long id, Model model) {

    logger.info("Entering OrderController.displayEditOrderPage with id: {}", id);

    OrdersModel order = ordersService.getOrderById(id);

    model.addAttribute("order", order);

    model.addAttribute("customers", customersService.getAllCustomers());

    logger.info("Exiting OrderController.displayEditOrderPage");
    return "edit-order";
}







// Save the edited order
@PostMapping("/orders/update")
public String editOrder(@ModelAttribute("order") OrdersModel order) {

    logger.info("Entering OrderController.editOrder with orderId: {}", order.getOrderId());
    Long customerId = order.getCustomer().getCustomerId();

    CustomerModel customer = customersService.getCustomerById(customerId);

    if (customer == null) {

        return "redirect:/orders/edit/" + order.getOrderId();
    }

    order.setCustomer(customer);

    ordersService.saveOrder(order);

    logger.info("Exiting OrderController.editOrder with orderId: {}", order.getOrderId());
    return "redirect:/orders";
}








@GetMapping("/orders/delete/{id}")
public String deleteOrder(@PathVariable("id") Long id) {

    logger.info("Entering OrderController.deleteOrder with id: {}", id);

    ordersService.deleteOrder(id);

    logger.info("Exiting OrderController.deleteOrder with id: {}", id);

    return "redirect:/orders";
}
}
