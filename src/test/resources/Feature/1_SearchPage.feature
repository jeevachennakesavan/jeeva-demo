Feature: Search for a product on Flipkart

  Background: 
    Given the user is on the Flipkart homepage

  @positive
  Scenario Outline: Search for a valid product
    When the user searches for "<ValidProduct>" based on "<row>"
    Then the product results should be displayed

    Examples: 
      | ValidProduct | row |
      | Sheet1       |   1 |
      | Sheet1       |   2 |
      | Sheet1       |   3 |

  @negative
  Scenario Outline: Search for an invalid product
    When the user searches for "<InvalidProduct>" based on "<row>"
    Then a message should be displayed stating "Sorry, no results found!"

    Examples: 
      | InvalidProduct | row |
      | Sheet2         |   1 |
      | Sheet2         |   2 |
      | Sheet2         |   3 |
