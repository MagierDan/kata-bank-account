package com.magier.kata.bank.account.domain;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Account {
    private int balance;
    private final LocalDate creatioDate;
    private LocalDate lastOperationDate;

    private List<Operation> operations = new LinkedList<>();

    public Account() {
        creatioDate = LocalDate.now();
        balance = 0;
    }

    public Account(final LocalDate creatioDate) {
        this.creatioDate = creatioDate;
        balance = 0;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public LocalDate getCreatioDate() {
        return creatioDate;
    }

    public int getBalance() {

        return balance;
    }

    public void setLastOperationDate(LocalDate lastOperationDate) {
        this.lastOperationDate = lastOperationDate;
    }

    public LocalDate getLastOperationDate() {
        return lastOperationDate;
    }

    public void showBalance() {
        System.out.println("Balance account is " + balance + "€ since " + lastOperationDate);
    }

    public void executeOperation(Operation operation) {
        Optional<Operation> operationOpt = Optional.ofNullable(operation);
        operationOpt.orElseThrow(IllegalArgumentException::new);

        Optional<Integer> amountOpt = Optional.ofNullable(operation.getAmount());
        amountOpt.orElseThrow(IllegalArgumentException::new);

        Optional<LocalDate> operationDateOpt = Optional.ofNullable(operation.getDate());
        operationDateOpt.orElseThrow(IllegalArgumentException::new);

        Optional<OperationType> operationTypeOpt = Optional.ofNullable(operation.getType());
        operationTypeOpt.orElseThrow(IllegalArgumentException::new);

        int amount = operation.getAmount();
        if (OperationType.WITHDRAWAL == operation.getType()) {
            amount = -operation.getAmount();
        }
        balance += amount;
        lastOperationDate = operation.getDate();

        operations.add(0, operation);
    }
}
