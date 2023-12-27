
@tag
Feature: Purchase teh order from Ecomm website
  I want to use this template for my feature file
  
   
  Background
   Given I Lnaded on ecommerce  Page
  

  @tag2
  Scenario Outline: Positive test of submittting the order
    Given I logged in  with username <name> and password <password>
    When I add product  <productname> to cart
    and checkout <productname> and submit the order
    Then  "HANKYOU FOR THE ORDER." is displayed on confirmation page

    Examples: 
      | name                 | password        | productname  |
      | zraj231640@gmail.com |   Dreambig@2023 | I PHONE 13 PRO |
      