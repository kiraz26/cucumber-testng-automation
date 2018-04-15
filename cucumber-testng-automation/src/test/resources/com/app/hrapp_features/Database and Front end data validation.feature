Feature: Hr Application Database and UI data verification

Background:
	Given I am on DeptEmpPage
	
	

  Scenario: Department data UI and Database verification
  	When I search for department id 10
  	And I query database with sql "SELECT department_name, manager_id, location_id FROM departments where department_id=10"
		Then UI data and Database data must match
@HRAppDB		
	Scenario: First name lastname search by email-UI vs DB verification
		When I search for email "JWHALEN" to see firstname and lastname
		And I query database with sql "SELECT first_name, last_name FROM employees WHERE email='JWHALEN'"
		Then UI data and Database data must match
	
	
	
	
	
	
	
	
	
	
	
	
	