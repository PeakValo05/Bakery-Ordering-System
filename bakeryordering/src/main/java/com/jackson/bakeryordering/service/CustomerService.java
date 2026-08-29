package com.jackson.bakeryordering.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jackson.bakeryordering.model.CustomerModel;
import com.jackson.bakeryordering.model.OrdersModel;
import com.jackson.bakeryordering.repository.CustomerRepository;
import com.jackson.bakeryordering.repository.OrdersRepository;


@Service    
public class CustomerService {


    private final CustomerRepository customersRepository;


    private final OrdersRepository ordersRepository;

    public CustomerService(CustomerRepository customersRepository, OrdersRepository ordersRepository) {
        this.customersRepository = customersRepository;
        this.ordersRepository = ordersRepository;
    }

    public List<CustomerModel> getAllCustomersList() {
        return (List<CustomerModel>) customersRepository.findAll();
    }

    public Iterable<CustomerModel> getAllCustomers() {
        return customersRepository.findAll();
    }

    public void saveCustomer(CustomerModel customer) {
        customersRepository.save(customer);
    }

    public CustomerModel getCustomerById(Long id) {
        return customersRepository.findById(id).orElse(null);
    }


    public void deleteCustomer(Long id) {
        customersRepository.deleteById(id);
    }

    public void saveOrder(OrdersModel order) {
        ordersRepository.save(order);
    }

    public OrdersModel getOrderById(Long id) {
        return ordersRepository.findById(id).orElse(null);
    }
    public void deleteOrder(Long id) {
        ordersRepository.deleteById(id);
    }
    public CustomerModel findCustomerById(Long id) {
        return customersRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found" + "with id: " + id));
    }
}

