
@tag
Feature: ErrorValidationsTest
  I want to use this template for my feature file

 

  @ErrorValidation
  Scenario Outline: Validating the Incorrect Username and password
  Given I landed on the Ecommerce Page
   When Logged in with Username <name> and password <password>
    Then "Incorrect email or password." message is displayed 

  Examples: 
      | name  									 |     password		|   productname   |
      | steaphenrahul3@gmail.com |     Rahul@199 |  ZARA COAT 3   |