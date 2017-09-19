Feature: As a bank client, in order to check my operations, I want to see the balance of my operations.

  Scenario: Displaying a bank account balance of more than two records
    Given an account opened the "12/07/2016" with a deposit of 0€
    And the customer make a deposit of 300€ the "13/07/2016"
    And the customer make a deposit of 1500€ the "14/07/2016"
    And the customer make a withdrawal of 500€ the "20/07/2016"
    And the customer make a deposit of 200€ the "25/07/2016"
    When the system display the account bank balance
    Then the customer's bank account balance is 1500€