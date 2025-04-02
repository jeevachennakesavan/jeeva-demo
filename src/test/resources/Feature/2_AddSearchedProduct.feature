Feature: Add a product to the cart on Flipkart

  @positive
  Scenario Outline: Add a product to the cart
    Given the user is on the Flipkart homepage
    When the user searches for "<ValidProduct>" based on "<row>"
    And selects the product from the results
    And clicks on Add to Cart.
    Then the product should be added to the cart successfully

    Examples: 
      | ValidProduct | row |
      | Sheet1       |   1 |
      | Sheet1       |   2 |
      | Sheet1       |   3 |
