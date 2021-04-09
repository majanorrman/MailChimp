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
Then I get successfully redirected to the confirmation page

Examples:
    | email  	             | randomLength | username  | password        |
    | "john@gmail.com"     | 20           | "john"   | "TestExample1!"  |
    | "eve@gmail.com"      | 20           | "eve"    | "TestExample1!"  |
    | "john@gmail.com"     | 100          | "john"    | "TestExample1!" |
    | "eve@gmail.com"      | 101          | "eve"     | "TestExample1!" |
    | ""                   | 20           | "johndoe" | "TestExample1!" |
    | ""                   | 20           | "evedoe"  | "TestExample1!" |
    | "john.doe@gmail.com" | 0            | "johndoe" | "TestExample1!" |
    | "jane.doe@gmail.com" | 0            | "janedoe" | "TestExample1!" |