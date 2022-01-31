package com.banking.Spiral.controllers;

import com.banking.Spiral.entities.Role;
import com.banking.Spiral.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/role")
@CrossOrigin
public class RoleController {

    // Service
    RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<Role> getAll() {
        return roleService.getAll();
    }

    @GetMapping(path = "{role_id}")
    public Role getRole(@PathVariable("role_id") Long role_id) {
        return roleService.getOne(role_id);
    }

    @PostMapping
    public Role postRole(@RequestBody Role role) {
        return roleService.postRole(role);
    }

    @PutMapping(path = "{role_id}")
    public Role updateRole(@PathVariable("role_id") Long id, @RequestBody Role role) {
        return roleService.updateRole(id, role);
    }

    @DeleteMapping(path = "{role_id}")
    public boolean deleteRole(@PathVariable("role_id") Long id) {
        return roleService.deleteRole(id);
    }

}
