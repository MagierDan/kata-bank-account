package com.magier.kata.bank.account.domain;

import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class AccountTest {

    @Test
    public void makeADeposit_should_return_an_invalid_argument_exception_if_amount_is_null(){
        Account account = new Account();
        account.setBalance(150);
        account.setLastOperationdate(LocalDate.of(2017, 01, 3));

        assertThatThrownBy(() -> account.makeADeposit(null, LocalDate.now()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void makeADeposit_should_return_an_invalid_argument_exception_if_deposit_date_is_null(){
        Account account = new Account();
        account.setBalance(150);
        account.setLastOperationdate(LocalDate.of(2017, 01, 3));

        assertThatThrownBy(() -> account.makeADeposit(158, null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void makeAWithdarwal_should_return_an_invalid_argument_exception_if_amount_is_null(){
        Account account = new Account();
        account.setBalance(150);
        account.setLastOperationdate(LocalDate.of(2017, 01, 3));

        assertThatThrownBy(() -> account.makeAWithdarwal(null, LocalDate.now()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void makeAWithdarwal_should_return_an_invalid_argument_exception_if_deposit_date_is_null(){
        Account account = new Account();
        account.setBalance(150);
        account.setLastOperationdate(LocalDate.of(2017, 01, 3));

        assertThatThrownBy(() -> account.makeAWithdarwal(158, null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}