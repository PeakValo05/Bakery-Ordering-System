package com.jackson.bakeryordering.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventory")
public class InventoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Long inventoryId;

    @ManyToOne
    @JoinColumn(name = "products_id", nullable = false)
    private ProductsModel product;

    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private StaffModel staff;

    @ManyToOne
    @JoinColumn(name = "orders_id", nullable = false)
    private OrdersModel order;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "reorder_level")
    private int reorderLevel;

    @Column(name = "last_updated")
    private LocalDate lastUpdated;

    @Column(name = "total_products")
    private int totalProducts;





    // getters and setters

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public ProductsModel getProduct() {
        return product;
    }

    public StaffModel getStaff() {
        return staff;
    }

    public OrdersModel getOrder() {
        return order;
    }

    public void setProduct(ProductsModel product) {
        this.product = product;
    }

    public void setStaff(StaffModel staff) {
        this.staff = staff;
    }

    public void setOrder(OrdersModel order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public int getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(int totalProducts) {
        this.totalProducts = totalProducts;
    }
}