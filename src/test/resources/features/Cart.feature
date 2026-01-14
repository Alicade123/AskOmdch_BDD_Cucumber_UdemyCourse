Feature: Add to cart

  Scenario: Add one quantity from Store
    Given I'm on the Store Page of AskOmDch
    When I add a "Blue Shoes" in the cart
    Then I'm should see 1 "Blue Shoes" in the cart.