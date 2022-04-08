package com.x.service.impl;

import com.x.dao.AccountDao;
import com.x.service.AccountService;

/**
 * @author Gavin
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan,money);
        int i = 1 / 0;
        accountDao.in(inMan,money);
    }
}
