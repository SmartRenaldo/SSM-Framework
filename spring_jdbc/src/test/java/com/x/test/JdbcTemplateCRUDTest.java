package com.x.test;

import com.x.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class )
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRUDTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testUpdate() {
        jdbcTemplate.update("update account set money = ? where name = ?;", 10000, "锋哥");
    }

    @Test
    public void testDelete() {
        jdbcTemplate.update("delete from account where name = ?", "锋哥");
    }

    @Test
    public void testQueryAll() {
        List<Account> accounts = jdbcTemplate.query("select * from account",
                new BeanPropertyRowMapper<>(Account.class));

        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testQuerySingle() {
        Account account = jdbcTemplate.queryForObject("select * from account where name = ?",
                new BeanPropertyRowMapper<>(Account.class), "阿三");

        System.out.println(account);
    }

    @Test
    public void testQueryCount() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from account", Long.class);

        System.out.println(aLong);
    }
}
