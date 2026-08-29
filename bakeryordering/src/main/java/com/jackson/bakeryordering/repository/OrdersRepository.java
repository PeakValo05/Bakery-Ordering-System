package com.jackson.bakeryordering.repository;
import com.jackson.bakeryordering.model.OrdersModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrdersRepository extends JpaRepository<OrdersModel, Long> {
    
}
