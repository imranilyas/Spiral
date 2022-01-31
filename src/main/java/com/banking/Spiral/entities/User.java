package com.banking.Spiral.entities;

import javax.persistence.*;

@Entity
@Table
public class User {

    // User ID is the same as customer id
    // After creating a customer, the id will be used to make a user
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long user_id;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer", nullable = false)
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role", nullable = false)
    private Role role;

    public User() {};

    // For logging in
    public User(long user_id, String password) {
        this.user_id = user_id;
        this.password = password;
    }

    public User(long user_id, String password, Role role) {
        this.user_id = user_id;
        this.password = password;
        this.role = role;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
