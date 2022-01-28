package com.banking.Spiral.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Transaction {

    @Id
    @SequenceGenerator(
            name = "transactions_sequence",
            sequenceName = "transactions_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transactions_sequence"
    )
    private long transaction_id;
    private long reference_number;
    private Date time;
    private String withdraw_deposit;
    private double balance;

    @ManyToOne
    @JoinColumn(name = "account_number", nullable = false)
    private Account account;

    public Transaction() {}

    public Transaction(long reference_number, Date time, String withdraw_deposit, double balance) {
        this.reference_number = reference_number;
        this.time = time;
        this.withdraw_deposit = withdraw_deposit;
        this.balance = balance;
    }

    public Transaction(long transaction_id, long reference_number, Date time, String withdraw_deposit, double balance) {
        this.transaction_id = transaction_id;
        this.reference_number = reference_number;
        this.time = time;
        this.withdraw_deposit = withdraw_deposit;
        this.balance = balance;
    }

    public long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(long transaction_id) {
        this.transaction_id = transaction_id;
    }

    public long getReference_number() {
        return reference_number;
    }

    public void setReference_number(long reference_number) {
        this.reference_number = reference_number;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getWithdraw_deposit() {
        return withdraw_deposit;
    }

    public void setWithdraw_deposit(String withdraw_deposit) {
        this.withdraw_deposit = withdraw_deposit;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
