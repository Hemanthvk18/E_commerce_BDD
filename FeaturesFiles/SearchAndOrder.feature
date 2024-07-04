Feature: Order the product

Background:

Given Login

Scenario: search and Add_to_cart
  
    Given search and Add_to_cart the product
    When verify the Add_to_cart product
    And checkout the product
    Then Fill the address 
    And verify the order

  


