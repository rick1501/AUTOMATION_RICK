
Feature: Shopping flow in YourStore

  Scenario: Complete shopping flow end-to-end
    Given the user registers a new account
    And logs into the application
    When the user navigates to Laptops & Notebooks and shows all laptops
    And adds a MacBook Pro to the cart
    And searches for "Samsung Galaxy Tab" and adds it to the cart
    And removes the MacBook Pro from the cart
    And increases the quantity of Samsung Galaxy Tab in the cart
    And completes the checkout process
    Then the order should be confirmed successfully
