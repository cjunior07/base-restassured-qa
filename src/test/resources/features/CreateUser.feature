#language:en
  @Regression
  Feature: User Registration

  @createNewUser
  Scenario: User Creation
    Given I have a payload
    When I make a POST request to the path /users
    Then it should return the status code 201
    And it should return the contract "post.json"