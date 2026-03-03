package com.example.orders.Controller;

import com.example.orders.Model.Order;
import com.example.orders.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @GetMapping("")
    public List<Order> all(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Order one(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order){
        return service.save(order);
    }

    @PatchMapping("/{id}")
    public Order update(@PathVariable Long id, @RequestBody Order order){
        return service.updateStatus(id, order);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.deleteById(id);
    }

}
