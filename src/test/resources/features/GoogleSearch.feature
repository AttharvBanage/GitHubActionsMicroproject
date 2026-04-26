Feature: Google Search Functionality

  Scenario: User can search for a keyword
    Given the user opens the Google homepage
    When the user searches for "MIT ADT University"
    Then the page title should be validated