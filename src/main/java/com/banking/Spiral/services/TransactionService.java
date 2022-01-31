package com.banking.Spiral.services;

import com.banking.Spiral.entities.Transaction;
import com.banking.Spiral.repositories.AccountRepository;
import com.banking.Spiral.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransaction(Long id) {
        return transactionRepository.getById(id);
    }

    public Transaction postTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Transactional
    public Transaction updateTransaction(Long id, Transaction transaction) {
        Transaction update = transactionRepository.findById(id).orElseThrow(() -> new IllegalStateException("Transaction with " + id + " does not exist"));
        return transactionRepository.save(update);
    }

    public boolean deleteTransaction(Long id) {
        try {
            transactionRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

}
