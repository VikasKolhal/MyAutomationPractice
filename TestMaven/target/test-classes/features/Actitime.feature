Feature: Testing Actitime application

Scenario Outline: Testing actitime login functionality for <user> <username> <password>
Given user is alredy having URl as <url>
And also having usename as <username> and password as <password> for the application
When user enter the username and password And clicks on login button
Then Actitime home page will be displayed with application title as <title>

Examples:
| user        |   url                                  | username | password   | title                       |
| valid       |   https://demo.actitime.com/login.do        | admin    | manager    | actiTIME - Enter Time-Track |
| invalid     |   https://demo.actitime.com/login.do       | admin12  | manger     | actiTIME - Login            |
| invalid     |  https://demo.actitime.com/login.do         | admin    | manager23  | actiTIME - Login            |

