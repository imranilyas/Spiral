package com.banking.Spiral.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            initialValue = 100000,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    private long customer_id;

    // Personal Account Number
    private long pan;

    private long citizen_uid;
    private String name;
    private String address;
    private String email;
    private Date dob;

    @OneToOne(mappedBy = "customer")
    private User user;

    public Customer() {}

    public Customer(long pan, long citizen_uid, String name, String address, String email, Date dob) {
        this.pan = pan;
        this.citizen_uid = citizen_uid;
        this.name = name;
        this.address = address;
        this.email = email;
        this.dob = dob;
    }

    public Customer(long customer_id, long pan, long citizen_uid, String name, String address, String email, Date dob) {
        this.customer_id = customer_id;
        this.pan = pan;
        this.citizen_uid = citizen_uid;
        this.name = name;
        this.address = address;
        this.email = email;
        this.dob = dob;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public long getPan() {
        return pan;
    }

    public void setPan(long pan) {
        this.pan = pan;
    }

    public long getCitizen_uid() {
        return citizen_uid;
    }

    public void setCitizen_uid(long citizen_uid) {
        this.citizen_uid = citizen_uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
