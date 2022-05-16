Feature: Smoke
  As a user
  I want to test all main functionality of the web site
  So that I can be sure that site works properly

  Scenario Outline: Check that sum in cart is lower than expected after buying some product
    Given User opens '<homePage>' page
    And  User makes search by keyword '<keyword>'
    And User clicks product sort options button
    And User sorts products by lowest price
    And User adds first product to cart
    And User clicks cart button
    Then User checks that sum in cart is lower than <expectedSum>

    Examples:
      | homePage                | keyword     | expectedSum |
      | https://rozetka.com.ua/ | Ноутбук     | 50000       |
    