@LoginProfile
Feature: Send Letter
  I want to log in
  and try to send letter to incorrect receiver
  correct receiver and try to send again

  Scenario Outline: : Successful login
    When I fill username "<username>" and password "<password>"
    Then I am on the "inbox" page
    When I send letter with receiver, topic, message
    And I click on Send button
    Then alert dialog appear
    When I correct receiver with "a.lyabah@checkio.org"
    And I click on Send button
    Then letter with title should be in sent

    Examples:
      | username                              | password        |
      | groot.epam@gmail.com                  | iamgroot        |
      | paprika0015@gmail.com                 | 423489123789op  |
      | sonyachanter@gmail.com                | sonichka13      |
      | orest.zhmurkevych.secondary@gmail.com | passwordfortest |
      | zuckinnyjetsoftpro@gmail.com          | jetsoftprohui   |