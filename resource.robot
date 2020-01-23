*** Settings ***
Library     SeleniumLibrary
Library     DateTime
Library     Collections
Library     OperatingSystem

*** Variables ***
${URL}                    http://qa-interview.srcli.xyz/
${WELCOME}                //h1[contains (text(), 'Welcome!')]
${USERNAME}               //input[@name='username']
${PASSWORD}               //input[@name='password']
${SUBMIT}                 //input[@value='Login']
${H_PEMASUKAN}            //h1[text()='Pemasukan']
${H_PENGELUARAN}          //h1[text()='Pengeluaran']
${TIMESTAMP}              //th[text()='TimeStamp']
${DESKRIPSI}              //th[text()='Deskripsi']
${JUMLAH}                 //th[text()='Jumlah']
${START}                  //input[@name='start']
${END}                    //input[@name='end']
${FILTER}                 //input[@value='Filter']
${ERROR_MESSAGE}          //pre[contains (text(), 'Filter Parameter are wrong')]

*** Keywords ***
Go To Test Home Page
    Open Browser        ${URL}          chrome
    Set Selenium Speed    0.3s

Home Page Opened
    Page Should Contain Element    ${WELCOME}

Open Login Page
    Go To               ${URL}/login

Login Page Is Opened
    Page Should Contain Element     ${USERNAME}
    Page Should Contain Element     ${PASSWORD}
    Page Should Contain Element     ${SUBMIT}

Input ${args1} And ${args2}
    Click Element     ${USERNAME}
    Input Text        ${USERNAME}    ${args1}
    Click Element     ${PASSWORD}
    Input Password    ${PASSWORD}    ${args2}
    Click Button      ${SUBMIT}

Success Login
    Home Page Opened

Open Data Page
    Go To               ${URL}/data

Page Data Is Opened
    Page Should Contain Element     ${H_PEMASUKAN}
    Page Should Contain Element     ${H_PENGELUARAN}
    Page Should Contain Element     ${TIMESTAMP}
    Page Should Contain Element     ${DESKRIPSI}
    Page Should Contain Element     ${JUMLAH}
    Page Should Contain Element     ${START}
    Page Should Contain Element     ${END}
    Page Should Contain Element     ${FILTER}

Filter Data ${args1} to ${args2}
    Click Element    ${START}
    Input Text       ${START}    ${args1}
    Click Element    ${END}
    Input Text       ${END}      ${args2}
    Click Element    ${FILTER}

Success Filter Data
    Page Should Contain Element     ${H_PEMASUKAN}
    Page Should Contain Element     ${H_PENGELUARAN}
    Page Should Contain Element     ${TIMESTAMP}
    Page Should Contain Element     ${DESKRIPSI}
    Page Should Contain Element     ${JUMLAH}

Failed Filter Data
    Page Should Contain Element     ${ERROR_MESSAGE}

Logout
    Delete All Cookies
