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
    public long role_id;

    @Enumerated(EnumType.STRING)
    private String role;

    public long getRole_id() {
        return role_id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Role() {}

    public Role(long role_id, String role) {
        this.role_id = role_id;
        this.role = role;
    }
}
