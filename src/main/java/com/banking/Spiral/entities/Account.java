package com.banking.Spiral.entities;

import javax.persistence.*;

@Entity
@Table
public class Account {

    @Id
    @SequenceGenerator(
            name = "account_sequence",
            sequenceName = "account_sequence",
            initialValue = 1000000000,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_sequence"
    )
    private long account_number;
    private long customer_id;
    private double balance;

    public Account() {}

    public Account(long customer_id, double balance) {
        this.customer_id = customer_id;
        this.balance = balance;
    }

    public Account(long account_number, long customer_id, double balance) {
        this.account_number = account_number;
        this.customer_id = customer_id;
        this.balance = balance;
    }

    public long getAccount_number() {
        return account_number;
    }

    public void setAccount_number(long account_number) {
        this.account_number = account_number;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
