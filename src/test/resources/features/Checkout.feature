@CheckoutTests @AllTests
Feature: As a user I want to complete order on RS Components website

  @Test-1
  Scenario: Create order as a registered customer
    Given RS Components homepage is displayed
    And I am logged in as a customer
    And my basket is clear
    When I search for 'clock'
    And I add first product to basket from results list
    And I proceed to basket summary
    And I verify basket information is correct
    And I proceed to checkout
    And I verify saved address is present
    And I proceed to payment
    And I select 'MasterCard' from saved cards
    And I proceed to order review
    Then I verify order review page is displayed
    And I verify order information is correct

  @Test-2
  Scenario: Create order as a guest customer
    Given RS Components homepage is displayed
    And I am a guest customer
    And my basket is clear
    When I search for 'clock'
    And I change the quantity of first product to '2'
    And I add the product to basket from results list
    And I proceed to basket summary
    And I verify basket information is correct
    And I proceed to checkout as guest
    And I add delivery information
    And I proceed to payment
    And I add 'Visa' payment details
    And I proceed to order review
    Then I verify order review page is displayed
    And I verify order information is correct




