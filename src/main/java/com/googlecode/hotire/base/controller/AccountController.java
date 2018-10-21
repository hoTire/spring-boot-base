package com.googlecode.hotire.base.controller;

import com.googlecode.hotire.base.domain.Account;
import com.googlecode.hotire.base.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping()
    public Account create() {
        Account account = new Account();
        account.setEmail("tire@mail.com");
        account.setPassword("password");
        return accountService.create(account);
    }
}
