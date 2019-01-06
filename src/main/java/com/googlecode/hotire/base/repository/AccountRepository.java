package com.googlecode.hotire.base.repository;

import com.googlecode.hotire.base.domain.Account;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository {

    private Map<String,Account> accounts = new HashMap<>();
    private int id;

    public Account save(Account account) {
        account.setId(id++);
        accounts.put(account.getEmail(),account);
        return account;
    }

    public Account findByEmail(String email) {
        return accounts.get(email);
    }

}
