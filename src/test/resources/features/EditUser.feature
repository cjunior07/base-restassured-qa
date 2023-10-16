#language:en
@Regression
Feature: Edit a User

  @editUser
  Scenario: Edit a registered user
    Given I have a payload
    And I make a POST request to the path /users
    When I make a PATCH request to the path /users/{id}
    Then it should return the status code 200
    And it should return the contract "editUser.json"

