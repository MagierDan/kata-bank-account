package com.magier.kata.bank.account.domain;

import java.time.LocalDate;

public class Operation {
    private final LocalDate date;
    private final Integer amount;
    private final OperationType type;

    public Operation(LocalDate operationDate, Integer amount, OperationType operationType) {
        this.date = operationDate;
        this.amount = amount;
        this.type = operationType;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getAmount() {
        return amount;
    }

    public OperationType getType() {
        return type;
    }
}
