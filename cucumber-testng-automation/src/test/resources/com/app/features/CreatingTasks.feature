Feature: Creating tasks

  @functional @regression @taskcreation
  Scenario: Create a task
    Given I logged into suiteCRM
    When I click on create task
    And Set subject as "Refactor code"
    And Set status as "In Progress"
    And Start date is todays date
    And Due date is 25 days after todays date
    And Set "Medium" priority
    And Set description as "Automate test cases using Cucumber and Selenium"
    And Save the task
    Then Task details page should be displayed
    And Data should match with created task data
    Then I logout from application

  @taskcreation
  Scenario: Create a task
    Given I logged into suiteCRM
    When I click on create task
    And Set subject as "Refactor code"
    And Set status as "In Progress"
    And Start date is todays date
    And Due date is 25 days after todays date
    And Set "Medium" priority
    And Set description as "Automate test cases using Cucumber and Selenium"
    And Save the task
    Then Task details page should be displayed
    And Data should match with created task data
    Then I logout from application

  @taskcreation
  Scenario: Create a task
    Given I logged into suiteCRM
    When I click on create task
    And Set subject as "Refactor code"
    And Set status as "In Progress"
    And Start date is todays date
    And Due date is 25 days after todays date
    And Set "Medium" priority
    And Set description as "Automate test cases using Cucumber and Selenium"
    And Save the task
    Then Task details page should be displayed
    And Data should match with created task data
    Then I logout from application

  @taskcreation
  Scenario: Create a task
    Given I logged into suiteCRM
    When I click on create task
    And Set subject as "Refactor code"
    And Set status as "In Progress"
    And Start date is todays date
    And Due date is 25 days after todays date
    And Set "Medium" priority
    And Set description as "Automate test cases using Cucumber and Selenium"
    And Save the task
    Then Task details page should be displayed
    And Data should match with created task data
    Then I logout from application
