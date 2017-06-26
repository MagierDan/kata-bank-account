package com.magier.kata.bank.account.domain.cucumber;

import com.magier.kata.bank.account.domain.Account;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by Dan on 25/06/2017.
 */
public class US1StepsDefinition {
    private Account account = new Account();

    @Given("^a bank account with a balance of (\\d+) € the \"([^\"]*)\"$")
    public void a_bank_account_with_a_balance_of_€_the(int accountBalance, String date) {
        account.setBalance(accountBalance);
        account.setLastOperationdate(getLocalDateFromString(date));
    }

    @When("^the customer make a deposit of (\\d+)€ the \"([^\"]*)\"$")
    public void the_customer_make_a_deposit_of_€_the(int depositAmount, String operationDate) throws Throwable {
        account.makeADeposit(depositAmount, getLocalDateFromString(operationDate));

    }

    @Then("^the customer's bank account balance is (\\d+)€$")
    public void the_customer_s_bank_account_balance_is_€(int expectedAccountBalance) throws Throwable {
        assertThat(expectedAccountBalance).isEqualTo(account.getBalance());
    }


    /*###########################################################################*/
    private LocalDate getLocalDateFromString(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, formatter);
    }
}
