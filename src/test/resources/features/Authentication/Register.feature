@register
Feature: Register
  As a user
  I want to register
  So I can create my account

  Scenario Outline: Register with email password and fullname
    Given I set url register
    When I input email "<email>" password "<password>" and fullname "<fullname>"
    Then I get register code "<status>"
    Examples:
      | email     | password | fullname  | status |
      | aa        | aa       | aa        | 400 |
      | aaaab     | password | lengkap   | 200 |
      |           | passwoyy | akun baru | 400 |
      | skip      |          | akun baru | 400 |
      | skip      | passcoyy |           | 400 |
      |           |          |           | 400 |
