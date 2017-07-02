package com.magier.kata.bank.account.domain.cucumber;

import com.magier.kata.bank.account.domain.Account;
import com.magier.kata.bank.account.domain.Operation;
import com.magier.kata.bank.account.domain.OperationType;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Dan on 25/06/2017.
 */
public class AccountStepsDefinition {
    Account account;
    String statement;

    @Given("^a bank account with a balance of (\\d+) € the \"([^\"]*)\"$")
    public void a_bank_account_with_a_balance_of_€_the(int accountBalance, String date) {
        account = new Account(new Operation(getLocalDateFromString(date), accountBalance, OperationType.CREATION));
    }

    @When("^the customer make a deposit of (\\d+)€ the \"([^\"]*)\"$")
    public void the_customer_make_a_deposit_of_€_the(int depositAmount, String operationDate) throws Throwable {
        account.executeOperation(new Operation(getLocalDateFromString(operationDate), depositAmount, OperationType.DEPOSIT));
    }

    @When("^the customer make a withdrawal of (\\d+)€ the \"([^\"]*)\"$")
    public void the_customer_make_a_withdrawal_of_€_the(int withdrawalAmount, String operationDate) throws Throwable {
        account.executeOperation(new Operation(getLocalDateFromString(operationDate), withdrawalAmount, OperationType.WITHDRAWAL));
    }

    @Then("^the customer's bank account balance is (\\d+)€$")
    public void the_customer_s_bank_account_balance_is_€(int expectedAccountBalance) throws Throwable {
        assertThat(expectedAccountBalance).isEqualTo(account.getBalance());
    }

    @Given("^an account opened the \"([^\"]*)\" with a deposit of (\\d+)€$")
    public void an_account_opened_the_with_a_deposit_of_€(String creationDate, int depositAmount) {
        account = new Account(new Operation(getLocalDateFromString(creationDate), depositAmount, OperationType.CREATION));
    }

    @When("^the system display the account bank statement$")
    public void the_system_display_the_account_bank_statement() {
        statement = account.getStatement();
    }

    @Then("^the customer should see$")
    public void the_customer_should_see(String expectedStatement) throws Throwable {
        assertThat(statement).isEqualTo(expectedStatement);
    }

    /*###########################################################################*/
    LocalDate getLocalDateFromString(String date) {
        return LocalDate.parse(date, Account.DATE_TIME_FORMATTER);
    }
}
