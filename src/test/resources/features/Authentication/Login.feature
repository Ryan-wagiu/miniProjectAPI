@login
Feature: Login
  As a user
  I want to login
  So I can manage my account

  Scenario Outline: Login with email and password
    Given I set url login
    When I input email "<email>" and password "<password>"
    Then I get login message "<status>"
    Examples:
      | email             | password | status |
      | imanuel@gmail.com | 123456   | succes |
      | imanuel@gmail.com | 000000   | failed |
      | imanuel@gmail.com |          | failed |
      |                   | 123456   | failed |
      | test@mail.co      | 123456   | failed |