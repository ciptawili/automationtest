# new feature
# Tags: optional

Feature: Login Test

  @Positive
  Scenario: Valid Login
    Given Open Login Page
    When Input email "<>" and password "<>"
    Then Login Successful