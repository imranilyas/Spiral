package com.banking.Spiral.services;

import com.banking.Spiral.entities.User;
import com.banking.Spiral.repositories.CustomerRepository;
import com.banking.Spiral.repositories.RoleRepository;
import com.banking.Spiral.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, CustomerRepository customerRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
        this.roleRepository = roleRepository;
    }

    // Get All Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get User by ID
    public User getUser(Long id) {
        return userRepository.getById(id);
    }

    // Post User
    public User postUser(User user) {
        return userRepository.save(user);
    }

    // Update User
    @Transactional
    public User updateUser(Long id, User user) {
        User update = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("User with ID " + id + " does not exist."));
        return userRepository.save(update);
    }

    // Delete User
    public boolean deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

}
