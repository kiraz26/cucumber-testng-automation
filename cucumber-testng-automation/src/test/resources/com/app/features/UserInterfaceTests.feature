Feature: User Interface for SuiteCRM

@Regression @10x
Scenario: CRM Name and Modules 
#	Given I logged into suiteCRM
	Then CRM name should be SuiteCRM
	And Modules should be displayed
#	Then I logout from application
