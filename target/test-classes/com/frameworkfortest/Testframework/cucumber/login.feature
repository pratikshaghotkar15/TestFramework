Feature: Login to OrangeHRM
  As a valid user,
  I want to log in to the OrangeHRM application
  So that I can access the dashboard.

  Background:
    Given the OrangeHRM login page is open

  Scenario: Successful login with valid credentials
    When I enter the username "admin"
    And I enter the password "admin123"
    And I click the login button
    Then I should see the dashboard page
    
    
    Scenario: Unsuccessful login with empty username
    When I leave the username field empty
    And I enter the password "admin123"
    And I click the login button
    Then I should see an error message "Username cannot be empty"

  Scenario: Unsuccessful login with empty password
    When I enter the username "admin"
    And I leave the password field empty
    And I click the login button
    Then I should see an error message "Password cannot be empty"