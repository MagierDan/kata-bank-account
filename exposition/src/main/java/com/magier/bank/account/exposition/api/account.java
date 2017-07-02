package com.magier.bank.account.exposition.api;

import com.magier.kata.bank.account.domain.Operation;
import com.magier.kata.bank.account.domain.OperationType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/api")
public class account {

    @RequestMapping(value = "/account/execute-operation", method = RequestMethod.GET)
    public String executeOperation(
            @RequestParam(value = "operationDate") @DateTimeFormat(pattern = "dd/MM/yyyy") final LocalDate operationDate,
            @RequestParam(value = "amount") final Integer amount,
            @RequestParam(value = "operationType") final OperationType operationType) {
        Operation operation = new Operation(operationDate, amount, operationType);

        return operation.toString();
    }
}
