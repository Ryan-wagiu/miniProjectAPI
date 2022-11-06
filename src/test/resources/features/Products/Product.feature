@product
Feature: Product
  As a user
  I want to product
  So I can manage my product

  Scenario: Get all Product
    Given I set url get product
    When I request get product
    Then I get all product

  Scenario Outline: Create new product
    Given I set url get product
    When I input product with name "<name>" desc "<desc>" price <price> and categories <cate>
    Then I get code "<code>"
    Examples:
      | name   | desc                | price | cate | code |
      | hape   | ini adalah telepon  | 3000 |    1 | 200 |
      |        | produk kosong       | 1000 |    1 | 500 |
      | hape   |                     | 1000 |    1 | 200 |
      | hape   | bukan merek hp      |   0  |    1 | 200 |
      | hape   | kawe tiga           | 500  |  0   | 200 |
      |        |                     | 0    |  0   | 500 |


  Scenario: Delete a product
    Given I set url get product
    When I request delete product
    Then success delete product

  Scenario: Get Product By id
    Given I set url get product by id
    When I want to get by id
    Then I get product by id