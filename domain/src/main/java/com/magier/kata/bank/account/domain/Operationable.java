package com.magier.kata.bank.account.domain;

public interface Operationable {
    void executeOperation(String accountNumber, Operation operation);
}
