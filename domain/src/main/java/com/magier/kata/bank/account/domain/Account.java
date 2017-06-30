package com.magier.kata.bank.account.domain;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Account {
    private int balance;
    private LocalDate lastOperationDate;

    private List<Operation> operations = new LinkedList<>();

    public Account(final Operation operation) {
        executeOperation(operation);
    }

    public int getBalance() {

        return balance;
    }

    public void executeOperation(Operation operation) {
        checkOperation(operation);

        determineBalance(operation);
        lastOperationDate = operation.getDate();

        operations.add(0, operation);
    }

    private void checkOperation(Operation operation) {
        Optional<Operation> operationOpt = Optional.ofNullable(operation);
        operationOpt.orElseThrow(IllegalArgumentException::new);
    }

    private void determineBalance(Operation operation) {
        int amount = operation.getAmount();
        if (OperationType.WITHDRAWAL == operation.getType()) {
            amount = -operation.getAmount();
        }
        balance += amount;

        operation.setBalanceAfterOperation(balance);
    }

    public void displaySatement() {
        System.out.println("Operation  || Date       || Amount    || Balance");
        operations.forEach(operation -> {
            System.out.println(operation.getDate() + "||" + operation.getType() + "||" + operation.getAmount() + "||" + operation.getBalanceAfterOperation());
        });
    }
}
