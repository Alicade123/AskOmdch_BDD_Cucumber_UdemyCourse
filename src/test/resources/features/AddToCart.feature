@addToCart
  Feature: Add product to cart
    As a customer of AskOmDch website
    I want to add a product to the cart
    So that I can purchase the product

Rule: Add product from StorePage

    Scenario:Add one Quantity to the cart
      Given I'm on the Store Page
      When I add a "Blue Shoes" to the Cart
      Then I see 1 "Blue Shoes" in the Cart