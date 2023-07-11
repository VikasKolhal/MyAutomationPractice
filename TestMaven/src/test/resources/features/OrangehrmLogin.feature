Feature: As a user,I want to verify Orangehrm login page functionality

Scenario: Verify Login page components
Given user has entered a valid url
When user has opened chrome browser and entered the URL
Then user should be able to see username input field
And user should be able to see password input field
And user should be able to see login button
And user should be able to see forrgot your password link