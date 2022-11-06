@user
Feature: Get user Info
  As a user
  I want to get user data
  So I can see user information

  Scenario: Get User
    Given I set url Get user
    When I want to get user information
    Then I will get code get user