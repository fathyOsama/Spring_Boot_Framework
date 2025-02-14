package com.FathiOs.aopdemo.dao;

import com.FathiOs.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();
}
