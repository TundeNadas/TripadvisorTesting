Feature: Tripadvisor page Search Functionality testing
  Background:
    Given Open "Tripadvisor" webpage
    Then Accept cookie consent Popup

  Scenario: Search box is displayed
    When Verify the webpage title
    Then Verify if the search box is displayed

  Scenario: Valid search query with displayed search results on the page
    When Enter "Bali" in search textbox
    Then Verify that the search results are loaded "Bali"

  Scenario: Invalid search query with displayed appropriate error message
    When Enter "66516516598" in search textbox
    Then Verify the error message if displayed

