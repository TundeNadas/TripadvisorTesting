Feature: Tripadvisor page testing
  Background:
    Given Open "Tripadvisor" webpage
    Then Accept cookie consent Popup

  Scenario: Register
    When Click Main Page Sign In
    Then Choose continue with email
    Then Choose Join Option
    Then Enter First name "Naomi"
    Then Enter Last name "Bell"
    Then Enter Email adress "naomibell.tripadvisor@gmail.com"
    Then Enter Password "Testingpassword123!"
    And  Click Join Button

  Scenario: Sign In with invalid password
    When Click Main Page Sign In
    Then Choose continue with email
    Then Enter EmailAdress "naomibell.tripadvisor@gmail.com"
    Then Enter invalid Password "invalidpassword"
    Then Click Sign In Button
    Then Check for Sign in errors

  Scenario: Search box element verification
    When Verify the webpage title
    Then Enter "Bali" in search textbox
    Then Verify that the search results are loaded

  Scenario: Review Writing
#     #Requires Log In Before Scenario
#    When Click Main Page Sign In
#    Then Choose continue with email
#    Then Enter EmailAdress "naomibell.tripadvisor@gmail.com"
#    Then Enter password "Testingpassword123"
#    Then Click Sign In Button
    #Review Writing
    And  Click Main Review Button
    Then Enter "Aphrodite Hills Hotel by Atlantica" in review search box
    Then Click "Aphrodite Hills Hotel by Atlantica" result
    Then Set Review Rating 3
    Then Select When did you go?
    Then Select Who did you go with?
    Then Enter Review text "It was a pleasent stay"
    Then Enter Review title "Amazing experience"
    Then Check the Policy Checkbox
    And  Preview your review



