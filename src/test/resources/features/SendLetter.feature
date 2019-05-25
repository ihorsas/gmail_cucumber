@LoginProfile
Feature: Send Letter
  As an employee of the company
  I want to login my employee profile using my credentials
  In order to collaborate with my colleagues

  Scenario Outline: : Successful login
    When I fill username "<username>" and password "<password>"
    Then I am on the "inbox" page
    When I send letter with receiver, title, message
    And I click on Send button
    Then alert dialog appear
    When I correct receiver with "vsydoriak99@gmail.com "
    And I click on Send button
    Then letter with title should be in sent

    Examples:
    | username| password |
    | groot.epam@gmail.com | iamgroot |
    | paprika0015@gmail.com | 423489123789op |
    | sonyachanter@gmail.com | sonichka13 |
    | orest.zhmurkevych.secondary@gmail.com | passwordfortest |
    | zuckinnyjetsoftpro@gmail.com | jetsoftprohui |