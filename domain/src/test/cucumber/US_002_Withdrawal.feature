Feature: As a bank client, in order to retrieve some or all of my savings, I want to make a withdrawal from my account

  Scenario: Making a withdrawal of 100€ the 05/06/2017 on a bank account having 300€ the 01/06/2017
    Given a bank account with a balance of 300 € the "01/06/2017"
    When the customer make a withdrawal of 100€ the "05/06/2017"
    Then the customer's bank account balance is 200€