package com.banking.Spiral.controllers;

import com.banking.Spiral.entities.Account;
import com.banking.Spiral.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/account")
@CrossOrigin
public class AccountController {

   // Service
   AccountService accountService;

   @Autowired
   public AccountController(AccountService accountService) {
       this.accountService = accountService;
   }

   @GetMapping
   public List<Account> getAllAccounts() {
      return accountService.getAllAccounts();
   }

   @GetMapping(path = "{account_id}")
   public Account getAccount(@PathVariable("account_id") Long account_id) {
      return accountService.getAccount(account_id);
   }

   @PostMapping
   public Account postAccount(@RequestBody Account account) {
      return accountService.postAccount(account);
   }

   @PutMapping(path = "{account_id}")
   public Account updateAccount(@PathVariable("account_id") Long account_id, @RequestBody Account account) {
      return accountService.editAccount(account_id, account);
   }

   @DeleteMapping(path = "{account_id}")
   public boolean deleteAccount(@PathVariable("account_id") Long account_id) {
      return accountService.deleteAccount(account_id);
   }

}
