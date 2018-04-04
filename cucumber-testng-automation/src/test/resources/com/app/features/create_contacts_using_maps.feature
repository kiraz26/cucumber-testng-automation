Feature: Creating contacts

  Scenario: Create contact using a map
    Given I logged into suiteCRM
    When I create a new contact:
      | first_name | John         |
      | last_name  | Smith        |
      | cell_phone | 801-888-8889 |
    Then I should see contact information for "John Smith"

  Scenario Outline: Create contact using a map
    Given I logged into suiteCRM
    When I create a new contact:
      | first_name   | <first_name>   |
      | last_name    | <lname>        |
      | cell_phone   | <cell_phone>   |
      | office_phone | <office_phone> |
    Then I should see contact information for "<first_name> <lname>"

    Examples: 
      | first_name | lname   | cell_phone   | office_phone |
      | Michael    | Jackson | 123129387129 |        34343 |
      | Bonnie     | Garcia  |       234234 |        24323 |

      
      
      
      
      
      
      
      
      
      
      
      