Feature: Login Feature
  Verify if user is able to Login in to the site
  Scenario: Login as a authenticated user
    Given user opens tiketa search
    When user accepts cookie
    When user writes corteo in Caption field
    When user selects avia solutions group arena event place
    When user selects date by input
    When user selects date by elements
    When user presses search button
    When user clicks buy
    Then user verifies list of tickets
