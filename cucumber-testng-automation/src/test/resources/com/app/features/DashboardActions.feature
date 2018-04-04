@notes 
Feature: Note on Dashboard

  Background: 
    Given I logged into suiteCRM
    
  @smoke  
  Scenario: Post a note on Dashboard
    When I post "Hello Everyone"
    Then Post should be displayed
    And I logout from application

  Scenario: Post another note on Dashboard
    When I post "Hello all"
    Then Post should be displayed
    And I logout from application
