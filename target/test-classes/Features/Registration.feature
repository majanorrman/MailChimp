Feature: Registration
In order to use the application
As a new user
I need to register an account

Scenario Outline: Register a new user
Given I am on the <registration_page> 
When I have written the <email> in its input-field
And I have written the <username> in its input-field
And I have written the <password> in its input-field
And I click the Sign Up button
Then I get redirected to another page # The new page asks the user to confirm their email through their inbox.

Examples:
    | registration_page                   | email | username | password |
    | https://login.mailchimp.com/signup/ | ""    |   "" 		 |   ""     |
    | https://login.mailchimp.com/signup/ | ""    |   ""     |   ""     |