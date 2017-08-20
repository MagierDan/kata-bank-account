package com.magier.kata.bank.account.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    @Mock
    OperationRepository operationRepository;

    @InjectMocks
    Account account;

    @Test
    public void executeOperation_should_return_an_invalid_argument_exception_if_operation_is_null() {
        assertThatThrownBy(() -> account.executeOperation(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void executeOperation_should_return_an_invalid_argument_exception_if_amount_is_null() {
        assertThatThrownBy(() -> account.executeOperation(new Operation(LocalDate.now(), null, OperationType.CREATION)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void executeOperation_should_return_an_invalid_argument_exception_if_operation_date_is_null() {
        assertThatThrownBy(() -> account.executeOperation(new Operation(null, 150, OperationType.CREATION)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void executeOperation_should_return_an_invalid_argument_exception_if_operation_type_is_null() {
        assertThatThrownBy(() -> {
            Operation operation = new Operation(LocalDate.of(2017, 01, 3), 150, null);
            account.executeOperation(operation);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void executeOperation_should_save_operation_on_execution() {
        Operation operation = new Operation(LocalDate.of(2017, 01, 3), 150, OperationType.CREATION);
        account.executeOperation(operation);

        Mockito.verify(operationRepository).saveOperation(operation);
    }
}