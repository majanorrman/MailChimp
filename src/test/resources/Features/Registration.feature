Feature: Mailchimp Registration
In order to use the application
As a new user
I need to register an account

@Before Go to the following page: 
https://login.mailchimp.com/signup/

Scenario Outline: Register a new user
Given I am on the registration page 
When I have filled up the following
| Email | Username | Password |
| <Email> | <Username> | <Password> | 
And I click the Sign Up button
Then I get redirected to another page # The new page asks the user to confirm their email through their inbox.

Examples: 
| Email | Username | Password |

