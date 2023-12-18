package com.example.springaopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public void addMembership() {
        System.out.println("Adding membership account");
    }

    @Override
    public void greetMember() {
        System.out.println("Hello member");
    }
}
