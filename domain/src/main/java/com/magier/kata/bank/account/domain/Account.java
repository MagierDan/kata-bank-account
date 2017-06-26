package com.magier.kata.bank.account.domain;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.util.Optional;

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
        System.out.println("Balance account is " + balance + "€ since " + lastOperationdate);
    }

    public void makeADeposit(Integer depositAmount, LocalDate operationDate) throws IllegalArgumentException {
        Optional<Integer> depositAmountOpt = Optional.ofNullable(depositAmount);
        depositAmountOpt.orElseThrow(IllegalArgumentException::new);
        Optional<LocalDate> operationDateOpt = Optional.ofNullable(operationDate);
        operationDateOpt.orElseThrow(IllegalArgumentException::new);

        balance += depositAmount;
        lastOperationdate = operationDate;
    }
}
