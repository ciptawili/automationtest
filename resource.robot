*** Settings ***
Library     SeleniumLibrary
Library     DateTime
Library     Collections
Library     OperatingSystem

*** Variables ***
${URL}                 http://automationpractice.com/
${LOGO}                //img[@class='logo img-responsive']

*** Keywords ***
Go To Test Home Page
    Open Browser        ${URL}          chrome

Verify Home Page
    Wait Until Element Is Visible    ${LOGO}
    Wait Until Element Is Visible    block_top_menu

Click Category ${category}
    Click Element       //ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//a[@title='${category}']

Verify category
    Wait Until Element Is Visible    element verify 
