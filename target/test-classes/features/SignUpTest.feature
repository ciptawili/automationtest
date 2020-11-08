# new feature
# Tags: optional

Feature: Sign Up

  @Positive
  Scenario: Sign Up With Valid Data
    Given Open sign up page
    When Sign up with valid data
    Then Success Sign Up