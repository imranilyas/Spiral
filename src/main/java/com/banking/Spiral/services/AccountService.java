package com.banking.Spiral.services;

import com.banking.Spiral.entities.Account;
import com.banking.Spiral.repositories.AccountRepository;
import com.banking.Spiral.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    // Get All Accounts
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Get Account by ID
    public Account getAccount(Long id) {
        return accountRepository.getById(id);
    }

    // Post Account
    public Account postAccount(Account account) {
        return accountRepository.save(account);
    }

    // Update Account Information
    @Transactional
    public Account editAccount(Long id, Account account) {
        Account updated = accountRepository.findById(id).orElseThrow(() -> new IllegalStateException("Account with " + id + " does not exist"));
        return accountRepository.save(updated);
    }

    // Delete Account by ID
    public boolean deleteAccount(Long id) {
        try {
            accountRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

}
