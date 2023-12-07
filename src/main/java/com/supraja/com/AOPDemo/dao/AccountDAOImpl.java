package com.supraja.com.AOPDemo.dao;

import com.supraja.com.AOPDemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{
    public String getName() {
        System.out.println(getClass() + " inGetName");
        return name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " in getServiceCode");

        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " inSetServiceCode");

        this.serviceCode = serviceCode;
    }

    public void setName(String name) {
        System.out.println(getClass() + " inSetName");

        this.name = name;
    }

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        //Simulating exception

        if (tripWire) {
            throw new RuntimeException("Simulating exception for AfterThrowing");
        }

        List<Account> accountList = new ArrayList<>();

        Account myAccount1 = new Account("Supraja" , "Gold");
        Account myAccount2 = new Account("Indu" , "Silver");

        accountList.add(myAccount1);
        accountList.add(myAccount2);

        return accountList;
    }

    private String name;
    private String serviceCode;
    @Override
    public boolean addSillyNumber(Account theAccount, boolean vip) {
        System.out.println(getClass() + "Doing my db work in AccountDAO");
        return true;
    }

    @Override
    public void doWork() {
        System.out.println("doing work");
    }
}
