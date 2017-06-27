package com.magier.kata.bank.account.domain;

import java.time.LocalDate;
import java.util.Optional;

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
        executeOperation(depositAmount, operationDate);
    }

    public void makeAWithdarwal(Integer withdrawalAmount, LocalDate operationDate) {
        Optional<Integer> withdrawalAmountOpt = Optional.ofNullable(withdrawalAmount);
        withdrawalAmountOpt.orElseThrow(IllegalArgumentException::new);
        executeOperation(-withdrawalAmount, operationDate);
    }

    private void executeOperation(Integer amount, LocalDate operationDate) {
        Optional<Integer> amountOpt = Optional.ofNullable(amount);
        amountOpt.orElseThrow(IllegalArgumentException::new);
        Optional<LocalDate> operationDateOpt = Optional.ofNullable(operationDate);
        operationDateOpt.orElseThrow(IllegalArgumentException::new);

        balance += amount;
        lastOperationdate = operationDate;
    }
}
