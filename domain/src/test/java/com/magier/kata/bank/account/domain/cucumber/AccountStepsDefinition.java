package com.magier.kata.bank.account.domain.cucumber;

import com.magier.kata.bank.account.domain.Account;
import com.magier.kata.bank.account.domain.Operation;
import com.magier.kata.bank.account.domain.OperationRepository;
import com.magier.kata.bank.account.domain.OperationType;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Dan on 25/06/2017.
 */

public class AccountStepsDefinition {
    private String statement;

    private OperationRepository operationRepository;
    private Account account;

    @Before
    public void setup() {
        operationRepository = Mockito.mock(OperationRepository.class);
        account = Mockito.spy(Account.class);
        account.setOperationRepository(operationRepository);
    }

    @Given("^a bank account with a balance of (\\d+) € the \"([^\"]*)\"$")
    public void a_bank_account_with_a_balance_of_€_the(int accountBalance, String date) {
        Operation operation = new Operation(getLocalDateFromString(date), accountBalance, OperationType.CREATION);
        account.executeOperation(operation);
    }

    @When("^the customer make a deposit of (\\d+)€ the \"([^\"]*)\"$")
    public void the_customer_make_a_deposit_of_€_the(int depositAmount, String operationDate) throws Throwable {
        Operation operation = new Operation(getLocalDateFromString(operationDate), depositAmount, OperationType.DEPOSIT);
        account.executeOperation(operation);
    }

    @When("^the customer make a withdrawal of (\\d+)€ the \"([^\"]*)\"$")
    public void the_customer_make_a_withdrawal_of_€_the(int withdrawalAmount, String operationDate) throws Throwable {
        Operation operation = new Operation(getLocalDateFromString(operationDate), withdrawalAmount, OperationType.WITHDRAWAL);
        account.executeOperation(operation);
    }

    @Then("^the customer's bank account balance is (\\d+)€$")
    public void the_customer_s_bank_account_balance_is_€(int expectedAccountBalance) throws Throwable {
        assertThat(expectedAccountBalance).isEqualTo(account.getBalance());
    }

    @Given("^an account opened the \"([^\"]*)\" with a deposit of (\\d+)€$")
    public void an_account_opened_the_with_a_deposit_of_€(String creationDate, int depositAmount) {
        Operation operation = new Operation(getLocalDateFromString(creationDate), depositAmount, OperationType.CREATION);
        account.executeOperation(operation);
    }

    @When("^the system display the account bank statement$")
    public void the_system_display_the_account_bank_statement() {
        statement = account.getStatement();
    }

    @When("^the system display the account bank balance$")
    public void the_system_display_the_account_bank_balance() {
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
