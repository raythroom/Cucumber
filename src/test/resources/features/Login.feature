Feature: Login Functionality

  Background:
    Given user is on the login page

  @Smoke
  @Regression
  Scenario: Successful login with valid credentials
    When user enters username "standard_user" and password "secret_sauce"
    And clicks on the login button
    Then user should be redirected to the home page