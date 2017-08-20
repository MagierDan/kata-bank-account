package com.magier.kata.bank.account.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class Account {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private int balance;
    private LocalDate lastOperationDate;
    private final String accountNumber;

    private OperationRepository operationRepository;

    private List<Operation> operations = new LinkedList<>();

    public Account() {
        this.accountNumber = UUID.randomUUID().toString();
    }

    public Account(final OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
        this.accountNumber = UUID.randomUUID().toString();
    }

    public int getBalance() {
        return balance;
    }

    public void executeOperation(Operation operation) {
        checkOperation(operation);

        determineBalance(operation);
        lastOperationDate = operation.getDate();

        operationRepository.saveOperation(operation);

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

    public String getStatement() {
        StringBuilder sb = new StringBuilder();
        sb.append("Operation || Date || Amount || Balance");
        operations.forEach(operation -> {
            sb.append(System.lineSeparator())
                    .append(operation.getType().getLabel())
                    .append(" || ")
                    .append(operation.getDate().format(DATE_TIME_FORMATTER))
                    .append(" || ")
                    .append(operation.getAmount()).append(" || ")
                    .append(operation.getBalanceAfterOperation());
        });

        return sb.toString();
    }

    public OperationRepository getOperationRepository() {
        return operationRepository;
    }

    public void setOperationRepository(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }
}
