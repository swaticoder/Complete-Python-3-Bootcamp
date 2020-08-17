Feature: subscribe the Newsletter

  Scenario: Verify that user can subscribe the Newsletter
    Given user want to subscribe for Newsletter
    When user enters e-mail address
    And user clicks on Inspire Me button
    Then Message will be displayed as You are now checked-in!
