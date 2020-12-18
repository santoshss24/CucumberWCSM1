Feature: Login

Scenario Outline: login with valid credentials

Given user navigates to login page.
And user enters <username> in username textField.
And user enters <password> in password textField.
When user clicks on login Button.
Then user should be able to successfully logged into homepage.

Examples:

|username|password|
|admin|manager|
|trainee|trainee|
