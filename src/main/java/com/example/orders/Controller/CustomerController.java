package com.example.orders.Controller;

import com.example.orders.DTO.Customer.CustomerRequest;
import com.example.orders.DTO.Customer.CustomerSummary;
import com.example.orders.Model.Customer;
import com.example.orders.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService service;

    @GetMapping("/{id}")
    public Customer one(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("/summaries/{id}")
    public CustomerSummary oneSummary(@PathVariable Long id){
        return service.findSummaryById(id);
    }

    @GetMapping("")
    public List<Customer> allCustomers(){
        return service.findAll();
    }

    @GetMapping("/summaries")
    public List<CustomerSummary> allCustomerSummaries(){
        return service.findAllSummaries();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer save(@RequestBody Customer customer){
        return service.save(customer);
    }

    @PatchMapping("/{id}")
    public Customer update(@PathVariable Long id, @RequestBody Customer customer){
        return service.update(id, customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.deleteById(id);
    }

}
