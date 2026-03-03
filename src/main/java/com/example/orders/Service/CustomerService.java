package com.example.orders.Service;

import com.example.orders.DTO.Customer.CustomerSummary;
import com.example.orders.Model.Customer;
import com.example.orders.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public Customer findById(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public CustomerSummary findSummaryById(Long id){
        return repository.findById(id).map(CustomerSummary::new)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public List<Customer> findAll(){
        return repository.findAll();
    }

    public List<CustomerSummary> findAllSummaries(){
        return repository.findAll().stream()
                .map(CustomerSummary::new)
                .collect(Collectors.toList());
    }

    public Customer save(Customer customer){
        return repository.save(customer);
    }

    public Customer update(Long id, Customer customer){
        return repository.findById(id).map(existing -> {
            existing.setName(customer.getName());
            existing.setEmail(customer.getEmail());
            existing.setAddress(customer.getAddress());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
