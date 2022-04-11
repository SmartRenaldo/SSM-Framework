package com.x.service;

import com.x.domain.Account;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gavin
 */
public interface AccountService {

    void save(Account account);

    List<Account> findAll();

}
