*** Settings ***
Resource         ../resource.robot


*** Variables ***


*** Test Cases ***
Skenario : Open Home Page
    Given Go To Test Home Page
    Then Home Page Opened
    [TearDown]  Close Browser

Scenario : Open Login Page
    Given Go To Test Home Page
    When Open Login Page
    Then Login Page Is Opened
    [TearDown]  Close Browser

Scenario : Login Success
    Given Go To Login Page
    When Input root And root123
    Then Success Login
    [TearDown]  Close Browser

Scenario : Open Login Page After Login
    Given Go To Login Page After Login
    Then Home Page Opened
    [TearDown]  Close Browser

Scenario : Open Page Data
    Given Go To Page Data
    Then Page Data Is Opened
    [TearDown]  Close Browser

Scenario : Open Page Data Before Login
    Given Go To Test Home Page
    When Open Data Page
    Then Login Page Is Opened
    [TearDown]  Close Browser

Scenario : Filter Data Success
    Given Go To Page Data
    When Filter Data 2018-07-01 to 2018-07-05
    Then Success Filter Data
    [TearDown]  Close Browser

Scenario : Filter Data Failed
    Given Go To Page Data
    When Filter Data 2018-07-07 to 2018-07-05
    Then Failed Filter Data
    [TearDown]  Close Browser

Scenario : Filter Data Failed
    [Tags]  data
    Given Go To Login Page
    When Input root And root123
    And Logout
    Then Home Page Opened
    [TearDown]  Close Browser

*** Keywords ***
Go To Login Page
    Go To Test Home Page
    Open Login Page
    Login Page Is Opened

Go To Login Page After Login
    Go To Test Home Page
    Open Login Page
    Login Page Is Opened
    Input root And root123
    Open Login Page

Go To Page Data
    Go To Test Home Page
    Open Login Page
    Login Page Is Opened
    Input root And root123
    Open Data Page
