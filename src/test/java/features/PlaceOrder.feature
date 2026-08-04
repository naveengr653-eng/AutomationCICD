
Feature: Purchase order and check in history page

Background:
Given Land on login page

@Regression
Scenario Outline: Place the order and checkout

Given Login with username <username> and password <password>
When Add the product <productName> to cart and checkout with country <country>
When Confirm the order
Then Check order is avilable in history page

Examples:
  |    username 			|   password 	  | productName 	 |country|
  | naveengr653@gmail.com   | Test@Practice1  | ZARA COAT 3		|India	 |