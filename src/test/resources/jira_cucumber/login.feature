Feature: User Login

  Scenario Outline: Successful Login with valid credentials
    Given the user is on the login page
    When the user enters a valid "<username>" and "<password>"
    And clicks the login button
    Then the user profile picture is displayed
    Examples:
      | username | password |
      | automation74 | CCAutoTest19.|


  Scenario: Successful Login with invalid credentials
    Given the user is on the login page
    When the user enters a invalid username and password
    And clicks the login button
    Then the error massage is displayed