package com.FathiOs.aopdemo.dao;

import com.FathiOs.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;

    private String serviceCode;

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripwire) {

        // if academic purposes ... simulate an exception
        if (tripwire){
            throw new RuntimeException("No soup for you !!!");
        }

        List<Account> MyAccounts = new ArrayList<>();

        Account temp1 = new Account("FathiOsama","Silver");
        Account temp2 = new Account("ShehabOsama","Gold");
        Account temp3 = new Account("MayarOsama","platinum");

        MyAccounts.add(temp1);
        MyAccounts.add(temp2);
        MyAccounts.add(temp3);


        return MyAccounts;
    }

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK : ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": doWork");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
