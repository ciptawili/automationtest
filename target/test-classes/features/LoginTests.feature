# new feature
# Tags: optional

Feature: Login Test

  @Positive
  Scenario: Valid Login
    Given Open Login Page
    When Input email "ciptawiliansyah@gmail.com" and password "ciptawili"
    Then Login Successful