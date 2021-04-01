Feature: Registration
In order to use the application
As a new user
I need to register an account

Scenario Outline: Register a new user
Given I am on the registration page 
When I have written <email> inside the email input-field with <randomLength> random characters
And I have written <username> inside the username input-field <randomLength> random characters
And I have written <password> inside the password input-field <randomLength> random characters
And I click the Sign Up button
# The new page asks the user to confirm their email through their inbox.
Then I get redirected to another page

Examples:
    | email  	         | randomLength | username | password        |
    | "john@gmail.com" | 20           | "john"   | "TestExample1!" |
    | "eve@gmail.com"  | 20           | "eve"    | "TestExample1!" |
    
Scenario Outline: Get username validation error
Given I am on the registration page 
When I have written <email> inside the email input-field with <randomLength> random characters
And I have written <username> inside the username input-field <randomLength> random characters
And I have written <password> inside the password input-field <randomLength> random characters
And I click the Sign Up button
Then I get a validation error that says that the username is too long

Examples:
    | email  | randomLength | username | password        |
    | "john@gmail.com" | 100          | "john"   | "TestExample1!" |
    | "eve@gmail.com"  | 101          | "eve"    | "TestExample1!" |


Scenario Outline: Get email validation error
Given I am on the registration page 
When I have written <email> inside the email input-field with <randomLength> random characters
And I have written <username> inside the username input-field <randomLength> random characters
And I have written <password> inside the password input-field <randomLength> random characters
And I click the Sign Up button
Then I get a validation error that says that the email is missing

Examples:
    | email  | randomLength | username | password        |
    | ""     | 0          | "john"   | "TestExample1!" |
    | ""     | 0          | "eve"    | "TestExample1!" |