package com.example.orders.DTO.OrderItem;

import com.example.orders.Model.OrderItem;

public class OrderItemSummary {

    private Long id;
    private Long orderId;
    private String productName;
    private Integer quantity;
    private Float price;

    public OrderItemSummary(OrderItem orderItem){
        this.setOrderId(orderItem.getId());
        this.setProductName(orderItem.getProductName());
        this.setQuantity(orderItem.getQuantity());
        this.setPrice(orderItem.getPrice());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

}
