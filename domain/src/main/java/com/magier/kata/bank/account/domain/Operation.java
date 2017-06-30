package com.magier.kata.bank.account.domain;

import java.time.LocalDate;
import java.util.Optional;

public class Operation {
    private final LocalDate date;
    private final Integer amount;
    private final OperationType type;

    public Operation(LocalDate operationDate, Integer amount, OperationType operationType) {
        controlOperationValues(operationDate, amount, operationType);
        this.date = operationDate;
        this.amount = amount;
        this.type = operationType;
    }

    private void controlOperationValues(LocalDate operationDate, Integer amount, OperationType operationType) {
        Optional<Integer> amountOpt = Optional.ofNullable(amount);
        amountOpt.orElseThrow(IllegalArgumentException::new);

        Optional<LocalDate> operationDateOpt = Optional.ofNullable(operationDate);
        operationDateOpt.orElseThrow(IllegalArgumentException::new);

        Optional<OperationType> operationTypeOpt = Optional.ofNullable(operationType);
        operationTypeOpt.orElseThrow(IllegalArgumentException::new);
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
