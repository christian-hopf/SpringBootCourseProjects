package com.example.springaopdemo.dao;

import com.example.springaopdemo.Account;

import java.util.List;

public interface AccountDAO {

    void addAccount(Account account, boolean flag);

    List<Account> findAccounts();

    int addAccountInt();

    void doNothing();

    String getName();

    void setName(String name);

    int getZipCode();

    void setZipCode(int zipCode);
}
