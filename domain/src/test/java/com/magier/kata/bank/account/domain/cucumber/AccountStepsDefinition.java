package com.magier.kata.bank.account.domain.cucumber;

import com.magier.kata.bank.account.domain.Account;
import cucumber.api.PendingException;
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
    protected Account account = new Account();

    @Given("^a bank account with a balance of (\\d+) € the \"([^\"]*)\"$")
    public void a_bank_account_with_a_balance_of_€_the(int accountBalance, String date) {
        account.setBalance(accountBalance);
        account.setLastOperationdate(getLocalDateFromString(date));
    }

    @When("^the customer make a deposit of (\\d+)€ the \"([^\"]*)\"$")
    public void the_customer_make_a_deposit_of_€_the(int depositAmount, String operationDate) throws Throwable {
        account.makeADeposit(depositAmount, getLocalDateFromString(operationDate));
    }

    @When("^the customer make a withdrawal of (\\d+)€ the \"([^\"]*)\"$")
    public void the_customer_make_a_withdrawal_of_€_the(int withdrawalAmount, String operationDate) throws Throwable {
        account.makeAWithdarwal(withdrawalAmount, getLocalDateFromString(operationDate));
    }

    @Then("^the customer's bank account balance is (\\d+)€$")
    public void the_customer_s_bank_account_balance_is_€(int expectedAccountBalance) throws Throwable {
        assertThat(expectedAccountBalance).isEqualTo(account.getBalance());
    }

    @Given("^an account without any operation opened the \"([^\"]*)\"$")
    public void an_account_without_any_operation_opened_the(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^the system display the operations history$")
    public void the_system_display_the_operations_history() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the customer should see$")
    public void the_customer_should_see(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    /*###########################################################################*/
    protected LocalDate getLocalDateFromString(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, formatter);
    }
}
