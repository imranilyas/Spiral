package com.banking.Spiral.controllers;

import com.banking.Spiral.entities.Customer;
import com.banking.Spiral.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/customer")
@CrossOrigin
public class CustomerController {

    // Service
    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "{customer_id}")
    public Customer getCustomer(@PathVariable("customer_id") Long customer_id) {
        return customerService.getCustomer(customer_id);
    }

    @PostMapping
    public Customer postCustomer(@RequestBody Customer customer) {
        return customerService.postCustomer(customer);
    }

    @PutMapping(path = "{customer_id}")
    public Customer updateCustomer(@PathVariable("customer_id") Long customer_id, @RequestBody Customer customer) {
        return customerService.updateCustomer(customer_id, customer);
    }

    @DeleteMapping(path = "{customer_id}")
    public boolean deleteCustomer(@PathVariable("customer_id") Long customer_id) {
        return customerService.deleteCustomer(customer_id);
    }
}
