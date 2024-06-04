Feature: Search project


  Scenario Outline: Search for project name and verify the first result
    Given the user is on the dashboard page
    When the user clicks on the project button
    And the user clicks on the show all projects button
    And the user enters "<projectName>" into the search bar
    And the user clicks on the first cell in the project table
    Then the first cell in the project table should contain "<projectName>"
    Examples:
      | projectName    |
      | coala project  |
      | jeti project  |
