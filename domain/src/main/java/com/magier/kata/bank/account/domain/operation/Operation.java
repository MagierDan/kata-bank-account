package com.magier.kata.bank.account.domain.operation;

import java.time.LocalDate;
import java.util.Optional;

public class Operation {
    private final LocalDate date;
    private final Integer amount;
    private final OperationType type;
    private Integer balanceAfterOperation;

    public Operation(final LocalDate operationDate, final Integer amount, final OperationType operationType) {
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

    public Integer getBalanceAfterOperation() {
        return balanceAfterOperation;
    }

    public void setBalanceAfterOperation(final Integer balanceAfterOperation) {
        this.balanceAfterOperation = balanceAfterOperation;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "date=" + date +
                ", amount=" + amount +
                ", type=" + type +
                '}';
    }
}
