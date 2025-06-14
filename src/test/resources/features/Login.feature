Feature: Login Functionality

  Background:
    Given user is on the login page

  @Smoke
    @Regression
  Scenario Outline: Successful login with valid credentials
    When user enters <username> and <password>
    And clicks on the login button
    Then user should be redirected to the home page

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | visual_user             | secret_sauce |

  @Smoke
  Scenario Outline: Unsuccessful login with invalid credentials
    When user enters <invalid_user> and <invalid_password>
    And clicks on the login button
    Then user should see an error message
    Examples:
      | invalid_user    | invalid_password |
      | locked_out_user | secret_sauce     |
      | error_user      | wrong_password   |
      | wrong_user      | secret_sauce     |
      | empty_user      | empty_password   |