
Feature: Add to cart
  As a customer of xyz website
  I want to add a product to the cart
  So that I can purchase the product


  Rule: rule 1
    Background: This is a first background
      Scenario: Dummy Scenario
        Given I am dummy
        When I do dummy things
        Then dummy things happens
        But It's ok

  Rule: rule 2
    Background: This is a second background
    @dummyFeature
      Scenario: Dummy Scenario
        Given I am dummy
        When I do dummy things
        Then dummy things happens


        Scenario Outline: Dummy Scenario 3
          Given I am dummy account balance is $<opening balance>
          When I withdraw $<withdraw amount>
          Then the account balance should be $<closing balance>
          Examples:
          |opening balance|withdraw amount|closing balance|
          |    100        |50             |50             |
          |    50         |50             | 0             |