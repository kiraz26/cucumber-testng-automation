Feature: Creating contacts

  Background: 
    Given I logged into suiteCRM

  Scenario: Create contact using CREATE page
    And I open the create contact page
    And I enter the first name "Donaldino1" and the last name "Duck"
    And I enter the phone number "202-000-0000"
    And I enter the department "IT"
    When click on the save button
    Then I should see contact information for "Donaldino1 Duck"

  Scenario: Create contact using CREATE page
    And I open the create contact page
    And I enter the first name "Sarah" and the last name "Connor"
    And I enter the phone number "202-000-0000"
    And I enter the department "IT"
    When click on the save button
    Then I should see contact information for "Sarah Connor"

  Scenario Outline: Create multiple contacts
    And I open the create contact page
    And I enter the first name "<firstname>" and the last name "<lastname>"
    And I enter the phone number "<phonenumber>"
    And I enter the department "<department>"
    When click on the save button
    Then I should see contact information for "<firstname> <lastname>"

    Examples: 
      | firstname | lastname | phonenumber    | department |
      | Satoshi   | Nakamuro | 98724398472947 | IT         |
      | John      | Smith    |     2131213212 | Sales      |
      | Rajesh    | Trewedi  |        2324324 | IT         |
      | Bonnie    | Garcia   |      234523543 | IT         |
      | Rhiannon  | Morrison | 1-917-4613     | aa         |
      | Zeus      | Wright   | 1-328-4518     | ing        |
      | Samantha  | Maxwell  | 1-678-3953     | ss         |
      | Neil      | Sampson  | 1-826-6519     | ting       |
      | Teagan    | Larsen   | 1-247-2016     | dd         |
      | Kermit    | Goff     | 1-732-3727     | ing        |
      | Dennis    | Hoffman  | 1-602-5630     | ting       |
      | Quon      | Frank    | 1-191-8707     | sdf        |
      | Mason     | Mendez   | 1-710-5803     | sd         |
      | Herrod    | Berry    | 1-966-9204     | ing        |
      | Inez      | Slater   | 1-442-3808     | df         |
      | Todd      | Lyons    | 1-537-7100     | df         |
      | Brendan   | Meyer    | 1-1280-7814    | df         |
