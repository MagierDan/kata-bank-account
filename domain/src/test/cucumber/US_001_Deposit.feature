#@wip
Feature: As a bank client, in order to save money, I want to make a deposit in my account

  Scenario: Making a deposit of 100€ on a new bank account created the 01/06/2017
    Given a bank account with a balance of 0 € the "01/06/2017"
    When the customer make a deposit of 100€
    Then the customer's bank account balance is 100€

  Scenario: Making a deposit of 200€ the 17/06/2017 on a bank account having a balance of 300€ since the 15/06/2017
    Given a bank account with a balance of 300 € the "15/06/2017"
    When the customer make a deposit of 200€
    Then the customer's bank account balance is 500€