package com.interfaces;

import com.models.Account;

public interface DAOAccounts {
    public void createAccount(Account account) throws Exception;
    public Account login(String username, String password) throws Exception;
    public Account Deposit_Withdraw(int id, String action, float amount) throws Exception;
}
