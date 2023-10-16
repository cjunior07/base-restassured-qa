#language:en
  @Regression
  Feature: Search User

  @searchUser
  Scenario: Search user by id
    Given I have a payload
    When I make a GET request to the path /users/{id}
    Then it should return the status code 200
    And it should return the contract "searchUser.json"