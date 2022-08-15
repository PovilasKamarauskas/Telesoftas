Feature: Login Feature
  Verify if user is able to Login in to the site
  Scenario: Login as a authenticated user
    Given user opens ticketa search
    When user writes Corteo in Caption field
    When user selects avia solutions group arena event place
    When user selects date by input
    When user selects date by elements
    When user presses search button
    When user clicks buy
    When user verifies list of tickets
		Then user quits