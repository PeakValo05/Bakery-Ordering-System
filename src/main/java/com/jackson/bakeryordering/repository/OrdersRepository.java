package com.jackson.bakeryordering.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jackson.bakeryordering.model.OrdersModel;


public interface OrdersRepository extends JpaRepository<OrdersModel, Long> {
    
}
