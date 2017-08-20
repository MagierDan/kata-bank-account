package com.magier.kata.bank.account.domain;

public interface AccountRepository {

    Account findAccount(String accountNumber);
}
