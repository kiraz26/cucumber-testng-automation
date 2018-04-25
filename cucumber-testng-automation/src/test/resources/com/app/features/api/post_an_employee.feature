Feature: Employee REST Api requests

  @ApiPost
  Scenario: Post an Employee method test
    Given Content Type and Accept type is JSON
    When I post a new Employee with "random" id
    Then Status code is 201
    When I send a GET request with "random" id
    Then Status code is 200
    And Employee JSON Response data should match the posted JSON data
