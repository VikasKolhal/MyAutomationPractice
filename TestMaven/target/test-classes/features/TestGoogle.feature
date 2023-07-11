Feature: As a user I want to cheack google search functionality
Scenario: Search 'SQL' in google
Given user is alredy in google serch page
When user types 'SQL'in in search input field and click on search button
Then user gets search result page with the title 'SQL - Google Search'
And close the browser

Scenario Outline: Search <textToBeSearched> in google
Given user is alredy in google search page
When user types <textToBeSearched> in search input filed and click on search button
Then user gate search result page with the title <expectedTitle>

Examples:
| textToBeSearched                  | expectedTitle                                  |
| Selenium 3.0                      | Selenium 3.0 - Google Search                    |
| Selenium 4.0                      | Selenium 4.0 - Google Search                    |
| Selenium interviw questions       | Selenium interviw questions - Google Search     |