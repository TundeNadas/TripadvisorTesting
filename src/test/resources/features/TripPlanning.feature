Feature: Tripadvisor page Trip Planning funtionality testing
  Background:
    Given Open "Tripadvisor" webpage
    Then Accept cookie consent Popup

  Scenario: Trips Menu page is displayed
    When Click Trips button
    Then Verify if the page is displayed

  Scenario: Create a trip
    When Click Trips button
    Then Click Get Started
    Then Continue with email
    Then Click SignIn Button
    Then Enter Email Address "naomibell.tripadvisor@gmail.com"
    Then Enter  Password "Testingpassword123"
    Then Click Inner SignIn Button
    Then Click Create trip
    Then Enter Trip name "Paphos"
    Then Choose Public
    Then Click Create button
    And  Verify if your Trip was created


