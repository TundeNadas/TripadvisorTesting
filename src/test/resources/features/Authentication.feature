Feature: Tripadvisor page Authentication testing
  Background:
    Given Open "Tripadvisor" webpage
    Then Accept cookie consent Popup

  Scenario: Register with existing email adress
    When Click Main Page SignIn
    Then Choose continue with email
    Then Choose Join Option
    Then Enter First name "Naomi"
    Then Enter Last name "Bell"
    Then Enter Email address "naomibell.tripadvisor@gmail.com"
    Then Enter Password "Testingpassword123!"
    And  Click Join Button
    #Register is failed because this email address is already is in usage.
    #An error message appeared.

  Scenario: Sign In with invalid password
    When Click Main Page SignIn
    Then Choose continue with email
    Then Enter EmailAddress "naomibell.tripadvisor@gmail.com"
    Then Enter invalid Password "invalidpassword"
    Then Click Sign In Button
    Then Check for Sign in error message

  Scenario: Sign In with valid credentials
    When Click Main Page SignIn
    Then Choose continue with email
    Then Enter EmailAddress "naomibell.tripadvisor@gmail.com"
    Then Enter invalid Password "Testingpassword123"
    Then Click Sign In Button