package com.banking.Spiral.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
public class Customers {

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
    private static Date dob;

    public Customers() {}

    public Customers(long pan, long citizen_uid, String name, String address, String email) {
        this.pan = pan;
        this.citizen_uid = citizen_uid;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public Customers(long customer_id, long pan, long citizen_uid, String name, String address, String email) {
        this.customer_id = customer_id;
        this.pan = pan;
        this.citizen_uid = citizen_uid;
        this.name = name;
        this.address = address;
        this.email = email;
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

    public static Date getDob() {
        return dob;
    }

    public static void setDob(Date dob) {
        Customers.dob = dob;
    }
}
