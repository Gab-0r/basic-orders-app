package com.example.orders.Model;

import com.example.orders.DTO.Order.OrderRequest;
import com.example.orders.DTO.OrderItem.OrderItemRequest;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_items")
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private String productName;
    private Integer quantity;
    private Float price;

    public static OrderItem from(OrderItemRequest orderItemRequest, Order order){
        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderItemRequest.getId());
        orderItem.setOrder(order);
        orderItem.setProductName(orderItemRequest.getProductName());
        orderItem.setQuantity(orderItem.getQuantity());
        orderItem.setPrice(orderItem.getPrice());
        return orderItem;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
