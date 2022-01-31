package com.banking.Spiral.services;

import com.banking.Spiral.entities.Role;
import com.banking.Spiral.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository repo) {
        this.roleRepository = repo;
    }

    // Get all Roles
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    // Get Role by ID
    public Role getOne(Long id) {
        return roleRepository.getById(id);
    }

    // Post a Role
    public Role postRole(Role role) {
        return roleRepository.save(role);
    }

    // Update a Role
    @Transactional
    public Role updateRole(Long id, Role role) {
        Role update = roleRepository.findById(id).orElseThrow(() -> new IllegalStateException("Role with id " + id + " does not exist"));
        return roleRepository.save(update);
    }

    // Delete a Role
    public boolean deleteRole(Long id) {
        try {
            roleRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

}
