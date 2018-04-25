Feature: Employee REST Api requests

  @ApiPost
  Scenario: Post an Employee method test
    Given Content Type and Accept type is JSON
    When I post a new Employee with "4532" id
    Then Status code is 201
    And Response Json should contain Employee info
    When I send a GET request with "4532" id
    Then Status code is 200
    And Employee JSON Response data should match the posted JSON data
