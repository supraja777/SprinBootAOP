package com.supraja.com.AOPDemo.dao;

import com.supraja.com.AOPDemo.Account;

import java.util.List;

public interface AccountDAO {
    boolean addSillyNumber(Account theAccount, boolean vip);
    void doWork ();

    public String getName();

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

    public void setName(String name);

    public List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);
}
