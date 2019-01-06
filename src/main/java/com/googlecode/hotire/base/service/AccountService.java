package com.googlecode.hotire.base.service;

import com.googlecode.hotire.base.domain.Account;
import com.googlecode.hotire.base.repository.AccountRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AccountService implements UserDetailsService, InitializingBean {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(username);

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        if (account == null) {
            log.info("Query returned no results for user : " + username);
            throw new UsernameNotFoundException("Invalid username and password.");
        }

        return new User(account.getEmail(), account.getPassword(), authorities);
    }

    public Account create(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepository.save(account);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Account account = new Account();
        account.setEmail("admin");
        account.setPassword(passwordEncoder.encode("1234"));
        accountRepository.save(account);
    }
}
