*** Settings ***
Resource         ../resource.robot


*** Variables ***


*** Test Cases ***
Test Category
    [Template]  Scenario : Open Category
    [TearDown]  Close Browser
    #category
    Women

*** Keywords ***
Scenario : Open Category
    [Arguments]  ${category_name}
    Given Go To Test Home Page
    When Click Category ${category_name}
    Then Verify category
