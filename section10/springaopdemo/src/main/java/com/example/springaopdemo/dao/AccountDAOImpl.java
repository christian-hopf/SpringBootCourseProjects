package com.example.springaopdemo.dao;

import com.example.springaopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;

    private int zipCode;

    @Override
    public void addAccount(Account account, boolean flag) {
        System.out.println("Adding account");
    }

    @Override
    public List<Account> findAccounts() {
        List<Account> accounts = new ArrayList<>();
        Account account1 = new Account("account1", "1");
        Account account2 = new Account("account2", "2");
        accounts.add(account1);
        accounts.add(account2);
//        throw new RuntimeException("Bruh");
        return accounts;
    }

    @Override
    public int addAccountInt() {
        System.out.println("Adding account and returning 1");
        return 1;
    }

    @Override
    public void doNothing() {
        System.out.println("Doing nothing");
    }

    public String getName() {
        System.out.println("Account getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println("Account setName()");
        this.name = name;
    }

    public int getZipCode() {
        System.out.println("Account getZipCode()");
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        System.out.println("Account setZipCode()");
        this.zipCode = zipCode;
    }
}
