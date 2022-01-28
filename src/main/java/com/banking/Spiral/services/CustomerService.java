package com.banking.Spiral.services;

import com.banking.Spiral.entities.Customer;
import com.banking.Spiral.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository repo) {
        this.customerRepository = repo;
    }

    // Get All Customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Get Customer by ID
    public Customer getCustomer(Long id) {
        return customerRepository.getById(id);
    }

    // Post Customer
    public Customer postCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Update Customer
    @Transactional
    public Customer updateCustomer(Long id, Customer customer) {
        Customer update = customerRepository.findById(id).orElseThrow(() -> new IllegalStateException("Customer with " + id + " does not exist"));
        return customerRepository.save(update);
    }

    // Delete Customer by ID
    public boolean deleteCustomer(Long id) {
        try {
            customerRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

}
