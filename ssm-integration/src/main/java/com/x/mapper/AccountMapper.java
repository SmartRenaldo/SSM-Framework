package com.x.mapper;

import com.x.domain.Account;

import java.util.List;

/**
 * @author Gavin
 */
public interface AccountMapper {

    public void save(Account account);

    public List<Account> findAll();

}
