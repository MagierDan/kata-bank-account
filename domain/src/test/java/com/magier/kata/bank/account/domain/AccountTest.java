package com.magier.kata.bank.account.domain;

import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class AccountTest {

    @Test
    public void executeOperation_should_return_an_invalid_argument_exception_if_amount_is_null(){
        Account account = new Account();
        account.setBalance(150);
        account.setLastOperationDate(LocalDate.of(2017, 01, 3));

        assertThatThrownBy(() -> account.executeOperation(new Operation(LocalDate.now(), null, Mockito.any())))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void executeOperation_should_return_an_invalid_argument_exception_if_operation_date_is_null(){
        Account account = new Account();
        account.setBalance(150);
        account.setLastOperationDate(LocalDate.of(2017, 01, 3));

        assertThatThrownBy(() -> account.executeOperation(new Operation(null, Mockito.any(), Mockito.any())))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void executeOperation_should_return_an_invalid_argument_exception_if_operation_type_is_null(){
        Account account = new Account();
        account.setBalance(150);
        account.setLastOperationDate(LocalDate.of(2017, 01, 3));

        assertThatThrownBy(() -> account.executeOperation(new Operation(Mockito.any(), Mockito.any(), null)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}