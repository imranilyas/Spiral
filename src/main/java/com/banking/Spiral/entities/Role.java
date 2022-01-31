package com.banking.Spiral.entities;

import javax.persistence.*;

@Entity
@Table
public class Role {

    @Id
    @SequenceGenerator(
            name = "role_sequence",
            sequenceName = "role_sequence",
            initialValue = 1000000,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "role_sequence"
    )
    private long role_id;
    private String role_name;

    // Relationship with User
    @OneToOne(mappedBy = "role")
    private User user;

    public Role() {}

    public Role(String role_name) {
        this.role_name = role_name;
    }

    public Role(long role_id, String role_name) {
        this.role_id = role_id;
        this.role_name = role_name;
    }

    public long getRole_id() {
        return role_id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
