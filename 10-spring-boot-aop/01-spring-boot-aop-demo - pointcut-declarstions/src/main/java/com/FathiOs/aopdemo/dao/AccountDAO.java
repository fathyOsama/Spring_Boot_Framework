package com.FathiOs.aopdemo.dao;

import com.FathiOs.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    // add a new method : findAccounts()
    List<Account> findAccounts();

    List<Account> findAccounts(boolean tripwire);

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);


}
