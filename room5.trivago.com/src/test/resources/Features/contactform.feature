Feature: Fill in the contact form

  Scenario: Verify that user is able to Fill the contact
    Given user is already on home page
    When user want to submit the contact form
    Then user enters  message and full Name and Email
    And user clicks on submit button
    Then Message Sent Successfully
