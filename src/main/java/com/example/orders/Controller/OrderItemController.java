package com.example.orders.Controller;

import com.example.orders.DTO.OrderItem.OrderItemRequest;
import com.example.orders.DTO.OrderItem.OrderItemSummary;
import com.example.orders.Model.OrderItem;
import com.example.orders.Service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderitems")
@RequiredArgsConstructor
public class OrderItemController {

    private final OrderItemService service;

    @GetMapping("")
    public List<OrderItemSummary> all(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public OrderItemSummary one(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderItemSummary save(@RequestBody OrderItemRequest orderItemRequest){
        return service.save(orderItemRequest);
    }

    @PatchMapping("/{id}")
    public OrderItemSummary update(@PathVariable Long id, @RequestBody OrderItem orderItem){
        return service.update(id, orderItem);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.deleteById(id);
    }

}
