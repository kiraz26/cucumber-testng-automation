Feature: Create contacts using beans

  # CTRL/CMD+SHIFT+F  formatting
  Scenario: Create contact
    Given I logged into suiteCRM
    When I save a new contact:
      | firstName | lastName | department | officePhone | cellPhone  | email           |
      | Steve     | Gates    | IT         |   415654654 | 9709870979 | gates@apple.com |
    Then I should see contact information for "Steve Gates"

  @create_contact
  Scenario Outline: Create way more contacts
    Given I logged into suiteCRM
    When I save a new contact:
      | firstName   | lastName   | department   | officePhone | cellPhone | email   |
      | <firstname> | <lastname> | <department> | <office>    | <cell>    | <email> |
    Then I should see contact information for "<firstname> <lastname>"

    Examples: 
      | firstname | lastname | department | office   | cell   | email             |
      | Admiral   | Kunkka   | navy       |   324234 |  34534 | admiral@valve.com |
      | John      | Smith    | navy       | 32423234 | 134534 | icefrog@valve.com |

      
      
      
      
      
      
      