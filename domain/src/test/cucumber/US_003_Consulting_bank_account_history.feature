Feature: As a bank client, in order to check my operations, I want to see the history (operation, date, amount, balance) of my operations

  Scenario: Displaying an empty history
    Given an account without any operation opened the "12/07/2016"
    When the system display the account bank statement
    Then the customer should see
      """
      operation  || date       || amount    || balance
      """

  Scenario: Displaying a history bank account of one record
    Given an account without any operation opened the "12/07/2016"
    And the customer make a deposit of 300€ the "13/07/2016"
    When the system display the account bank statement
    Then the customer should see
      """
      operation  || date       || amount    || balance
      Deposit    || 13/07/2016 || 300       || 300
      """

  Scenario: Displaying a history bank account of more than one record
    Given an account without any operation opened the "12/07/2016"
    And the customer make a deposit of 300€ the "13/07/2016"
    And the customer make a deposit of 1500€ the "14/07/2016"
    And the customer make a withdrawal of 500€ the "20/07/2016"
    And the customer make a deposit of 200€ the "25/07/2016"
    When the system display the account bank statement
    Then the customer should see
      """
      operation  || date       || amount    || balance
      Deposit    || 25/07/2016 || 200       || 1500
      withdrawal || 20/07/2016 || 500       || 1300
      Deposit    || 14/07/2016 || 1500      || 1800
      Deposit    || 13/07/2016 || 300       || 300
      """