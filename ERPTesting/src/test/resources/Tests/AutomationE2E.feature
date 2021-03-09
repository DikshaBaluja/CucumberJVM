Feature: Automation E2E

Scenario Outline: ERP Testing

Given User is on home page
Then User logs in with valid credentials with username <username> and password <password>
And User clicks on Getting Started
And User navigates to Item Module
And User creates new item

Examples:
|username                        |password      |
|testology.qa.learning@gmail.com |password      |