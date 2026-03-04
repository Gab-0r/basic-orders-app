package com.example.orders.DTO.Order;

import com.example.orders.DTO.Customer.CustomerSummary;
import com.example.orders.Model.Customer;
import com.example.orders.Model.Order;

import java.time.LocalDate;

public class OrderSummary {

    private Long id;
    private CustomerSummary customer;
    private LocalDate orderDate;
    private Float totalAmount;
    private String status;

    public OrderSummary(Order order, CustomerSummary customerSummary){
        this.setId(order.getId());
        this.setCustomer(customerSummary);
        this.setOrderDate(order.getOrderDate());
        this.setTotalAmount(order.getTotalAmount());
        this.setStatus(order.getStatus());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerSummary getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerSummary customer) {
        this.customer = customer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
