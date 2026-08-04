Feature: Login with invalid credentials and check validation 

Background:
Given Land on login page

@InvalidLogin
Scenario Outline: Place the order and checkout

Given Login with username <username> and password <password>
Then Check Validation has shown


Examples:
  |    username 			|   password 	  |
  | naveengr653@gmail.com   | Test@Practice2  |