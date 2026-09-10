package com.jackson.bakeryordering.service;

import org.springframework.stereotype.Service;

import com.jackson.bakeryordering.model.OrdersModel;
import com.jackson.bakeryordering.repository.OrdersRepository;


@Service    
public class OrdersService {


    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public Iterable<OrdersModel> getAllOrders() {
        return ordersRepository.findAll();
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
    
    public long getTotalOrders() {
        return ordersRepository.count();
    }

}
