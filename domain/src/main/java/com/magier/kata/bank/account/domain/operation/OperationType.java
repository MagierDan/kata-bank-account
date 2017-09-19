package com.magier.kata.bank.account.domain.operation;

/**
 * Created by Dan on 30/06/2017.
 */
public enum OperationType {

    DEPOSIT("Deposit"), WITHDRAWAL("Withdrawal"), CREATION("Deposit");

    private final String label;

    OperationType(final String label) {
        this.label=label;
    }

    public String getLabel() {
        return label;
    }
}
