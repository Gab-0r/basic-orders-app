package com.example.orders.Service;

import com.example.orders.Model.Order;
import com.example.orders.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public Order save(Order order){
        return repository.save(order);
    }

    public Order updateStatus(Long id, Order order){
        return repository.findById(id).map(existing -> {
            existing.setStatus(order.getStatus());
            return save(order);
        }).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
