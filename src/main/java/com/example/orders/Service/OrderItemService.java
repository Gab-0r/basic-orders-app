package com.example.orders.Service;
import com.example.orders.DTO.OrderItem.OrderItemRequest;
import com.example.orders.DTO.OrderItem.OrderItemSummary;
import com.example.orders.Model.Order;
import com.example.orders.Model.OrderItem;
import com.example.orders.Repository.OrderItemRepository;
import com.example.orders.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository repository;
    private final OrderRepository orderRepository;

    public List<OrderItemSummary> findAll(){
        return repository.findAll().stream()
                .map(OrderItemSummary::new)
                .collect(Collectors.toList());
    }

    public OrderItemSummary findById(Long id){
        return repository.findById(id)
                .map(OrderItemSummary::new)
                .orElseThrow(() -> new RuntimeException("Order item not found"));
    }

    public OrderItemSummary save(OrderItemRequest orderItemRequest){
        Order order = orderRepository.findById(orderItemRequest.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));
        OrderItem orderItem = repository.save(OrderItem.from(orderItemRequest, order));
        return new OrderItemSummary(orderItem);
    }

    public OrderItemSummary update(Long id, OrderItem orderItem){
        OrderItem editedOrderItem = repository.findById(id).map(existing -> {
            existing.setProductName(orderItem.getProductName());
            existing.setQuantity(orderItem.getQuantity());
            existing.setPrice(orderItem.getPrice());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Order item not found"));
        return new OrderItemSummary(editedOrderItem);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
