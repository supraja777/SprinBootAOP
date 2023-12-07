package com.supraja.com.AOPDemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public void addAccount() {
        System.out.println(getClass() + "Doing my db work in membershipDAO");

    }
}
