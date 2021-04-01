Feature: Registration
In order to use the application
As a new user
I need to register an account

Scenario Outline: Register a new user
Given I am on the <registration_page> 
When I have written <email> inside the email input-field
And I have written <username> inside the username input-field
And I have written <password> inside the password input-field
And I click the Sign Up button
# The new page asks the user to confirm their email through their inbox.
Then I get redirected to another page

Examples:
    | registration_page                   | email | username | password |
    | https://login.mailchimp.com/signup/ | ""    |   "" 		 |   ""     |
    | https://login.mailchimp.com/signup/ | ""    |   ""     |   ""     |