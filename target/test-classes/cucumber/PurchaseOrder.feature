
@tag
Feature: Purchase the order from Ecommerce website x
  
 Background:
 Given I landed on the Ecommerce Page
 

  @Regression
  Scenario Outline: positive test of submitting order
    Given Logged in with Username <name> and password <password>
    When I add the <productname> to Cart
    And Checkout <productname> and submit the Order
    Then "THANKYOU FOR THE ORDER." message is displayed in the Confirmation page

    Examples: 
      | name  									 |     password		|   productname   |
      | steaphenrahul3@gmail.com |     Rahul@1996 |  ZARA COAT 3   |
     
