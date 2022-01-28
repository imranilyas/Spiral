package com.banking.Spiral.controllers;

import com.banking.Spiral.entities.Transaction;
import com.banking.Spiral.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/transaction")
@CrossOrigin
public class TransactionController {

    // Service
    TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping(path = "{transaction_id}")
    public Transaction getTransaction(@PathVariable("transaction_id") Long transaction_id) {
        return transactionService.getTransaction(transaction_id);
    }

    @PostMapping
    public Transaction postTransaction(@RequestBody Transaction transaction) {
        return transactionService.postTransaction(transaction);
    }

    @PutMapping(path = "{transaction_id}")
    public Transaction updateTransaction(@PathVariable("transaction_id") Long transaction_id, @RequestBody Transaction transaction) {
        return transactionService.updateTransaction(transaction_id, transaction);
    }

    @DeleteMapping(path = "{transaction_id}")
    public boolean deleteTransaction(@PathVariable("transaction_id") Long transaction_id) {
        return transactionService.deleteTransaction(transaction_id);
    }

}