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
import com.jackson.bakeryordering.service.CustomerService;  



// Controller class for handling customer-related requests
@Controller
public class CustomerController {

    private static final Logger logger =
            LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customersService;

    public CustomerController(CustomerService customersService) {
        this.customersService = customersService;
    }

    @GetMapping("/customers")
    public String viewCustomers(Model model) {
        logger.info("Entering viewCustomers");

        model.addAttribute(
                "customers",
                customersService.getAllCustomers()
        );

        logger.info("Exiting viewCustomers");
        return "customers";
    }

    @GetMapping("/customers/add")
    public String displayAddCustomerPage(Model model) {
        logger.info("Entering displayAddCustomerPage");

        model.addAttribute("customer", new CustomerModel());

        logger.info("Exiting displayAddCustomerPage");
        return "add-customer";
    }

    @PostMapping("/customers/save")
    public String saveCustomer(
            @ModelAttribute("customer") CustomerModel customer) {

        logger.info("Entering saveCustomer");

        customersService.saveCustomer(customer);

        logger.info("Customer saved successfully");
        return "redirect:/customers";
    }

    @GetMapping("/customers/edit/{id}")
    public String displayEditCustomerPage(
            @PathVariable("id") Long id,
            Model model) {

        logger.info("Entering displayEditCustomerPage");

        CustomerModel customer =
                customersService.getCustomerById(id);

        model.addAttribute("customer", customer);

        logger.info("Exiting displayEditCustomerPage");
        return "edit-customer";
    }

    @PostMapping("/customers/update")
    public String editCustomer(
            @ModelAttribute("customer") CustomerModel customer) {

        logger.info("Entering editCustomer");

        customersService.saveCustomer(customer);

        logger.info("Customer updated successfully");
        return "redirect:/customers";
    }

    @GetMapping("/customers/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Long id) {
        logger.info("Entering deleteCustomer");

        customersService.deleteCustomer(id);

        logger.info("Customer deleted successfully");
        return "redirect:/customers";
    }
}