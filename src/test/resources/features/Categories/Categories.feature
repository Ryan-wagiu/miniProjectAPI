@categories
Feature: Product Category
  As a user
  I want to category product
  So I can manage my category product

  Scenario Outline: Product category create
    Given I set url get category create
    When I input "<name>" and description "<desc>"
    Then I get category "<status>"
    Examples:
      | name   | desc              | status |
      | Gaming | bagus buat gaming | 200    |
      |        |  mabar gan        | 500    |
      | gamen  |                   | 200    |
      |        |                   | 500    |

  Scenario: Get all category Product
    Given I set url get category
    When I request get all category
    Then I get all category

  Scenario Outline: Get category by id
    Given I set url get category
    When I request get by id category "<getid>"
    Then I get by id code "<code>"
    Examples:
      | getid | code |
      | 2     | 200 |
      | 1     | 404 |
      | -     | 400 |