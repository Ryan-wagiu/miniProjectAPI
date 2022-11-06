@order
Feature: Order
  As a user
  I want to order product
  So I can manage my order product

  @order
  Scenario Outline: Create order
    Given I set url order
    When I input product id <id> and qty <qty>
    Then I get status code "<code>"
    Examples:
      | id | qty | code |
      | 2 | 1 | 200     |
      | 1 | 2 | 200     |


  Scenario: Get all order
    Given I set url get order
    When I request get all order
    Then I get status code

  Scenario Outline: Get order by id
    Given I set url get order by id "<id>"
    When I request by id order
    Then I get status "<code>"
    Examples:
      | id | code |
      | 1 | 200 |
      |  | 400 |
      | 0 | 404 |