Feature: Manage a product in the Flipkart cart

  Background: 
    Given the user is on the Flipkart homepage

  @positive
  Scenario Outline: Add and remove a product from the cart
    When the user searches for "<ValidProduct>" based on "<row>"
    And selects the product from the results
    And clicks on Add to Cart.
    Then the product should be added to the cart successfully
    When the user removes the product from the cart
    Then a message should be displayed "Successfully removed"

    Examples: 
      | ValidProduct | row |
      | Sheet1       |   1 |
      | Sheet1       |   2 |
      | Sheet1       |   3 |
