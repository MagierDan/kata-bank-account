package com.magier.bank.account.exposition.api;

import com.magier.kata.bank.account.domain.Operation;
import com.magier.kata.bank.account.domain.OperationType;
import com.magier.kata.bank.account.domain.Operationable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/api")
public class AccountResource {
    private Operationable operationable;

    @RequestMapping(value = "/account:execute-operation", method = RequestMethod.POST)
    public String executeOperation(
            @RequestParam(value = "accountNumber") final String accountNumber,
            @RequestParam(value = "operationDate") @DateTimeFormat(pattern = "dd/MM/yyyy") final LocalDate operationDate,
            @RequestParam(value = "amount") final Integer amount,
            @RequestParam(value = "operationType") final OperationType operationType) {
        Operation operation = new Operation(operationDate, amount, operationType);
        operationable.executeOperation(accountNumber, operation);
        return operation.toString();
    }
}
