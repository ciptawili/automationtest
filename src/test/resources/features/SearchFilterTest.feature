# new feature
# Tags: optional

Feature: Search and Filter

  @Positive
  Scenario: Search product
    Given Go to Home Page
    And Search Address for discover store
    When Choose favourite supermarket
    And Search product "apel"
    Then Success search product with keyword "apel"

  @Positive
  Scenario: Search product
    Given Go to Home Page
    And Search Address for discover store
    When Choose favourite supermarket
    And Search product "apel"
    And Sorting product A-Z
    Then Success Sorting Product