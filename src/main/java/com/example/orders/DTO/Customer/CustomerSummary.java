package com.example.orders.DTO.Customer;

import com.example.orders.Model.Customer;

public class CustomerSummary {

    private Long id;
    private Long name;

    public CustomerSummary(Customer customer){
        this.setId(customer.getId());
        this.setName(customer.getId());
    }

    public Long getName() {
        return name;
    }

    public void setName(Long name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
