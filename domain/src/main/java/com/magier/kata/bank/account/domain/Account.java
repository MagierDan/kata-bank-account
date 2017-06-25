package com.magier.kata.bank.account.domain;

import java.time.LocalDate;

/**
 * Created by Dan on 25/06/2017.
 */
public class Account {
    private int balance;
    private LocalDate lastOperationdate;

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setLastOperationdate(LocalDate lastOperationdate) {
        this.lastOperationdate = lastOperationdate;
    }

    public LocalDate getLastOperationdate() {
        return lastOperationdate;
    }

    public void showBalance() {
        System.out.println("Balance account is " + balance + " since " + lastOperationdate);
    }

    public void makeADeposit(int depositAmount, LocalDate operationDate) {
        balance += depositAmount;
        lastOperationdate = operationDate;
    }
}
