@LoginProfile
Feature: Send Letter
  As an employee of the company
  I want to login my employee profile using my credentials
  In order to collaborate with my colleagues

  Background: User navigates to Company home page
    Given I go to URL "https://mail.google.com/"

  Scenario Outline: : Successful login
    When I fill username "groot.epam@gmail.com" and password "iamgroot"
    Then I am on the "inbox" page
    When I send letter with "<receiver>", "<title>", "<message>"
    And I click on Send button
    Then alert dialog appear
    When I correct receiver with "islamartinever@gmail.com"
    And I click on Send button
    Then letter with "<title>" should be in sent

    Examples:
    | receiver| title | message |
    | Tralala | Spoiler | THOR JOINS THE GUARDIANS OF THE GALAXY |