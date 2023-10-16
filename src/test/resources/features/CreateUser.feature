#language:en
  @Regression
  Feature: User Registration

  @createNewUser
  Scenario: User Creation
    Given I have a payload
    When I make a POST request to the path /users
    Then it should return the status code 201
    And it should return the contract "createUser.json"

    @validateFieldsCreationUser
    Scenario Outline: Validate body Fields User Creation
      And fill in the payload field <field> with the value "<value>"
      When I make a POST request to the path /users
      Then it should return the status code <code>

      Examples:
        | field | value                       | code |
        | name  | 123                         | 201  |
        | name  | !@#$                        | 201  |
        | name  | false                       | 201  |
        | name  | 5.generateNumbers           | 201  |
        | name  | 5.generateStringNumbers     | 201  |
        | name  | 100.generateString          | 201  |
        | name  | true                        | 201  |
        | name  | abcd                        | 201  |
        | name  |                             | 201  |
        | name  | null                        | 201  |
        | name  | 0                           | 201  |
        | name  | negativeNumber              | 201  |
        | name  | floatNumber                 | 201  |
        | job   | 123                         | 201  |
        | job   | aaaa                        | 201  |
        | job   |                             | 201  |
        | job   | null                        | 201  |
        | job   | 0                           | 201  |
        | job   | negativeNumber              | 201  |
        | job   | floatNumber                 | 201  |
        | job   | 5.generateNumbers           | 201  |
        | job   | 5.generateStringNumbers     | 201  |
        | job   | 100.generateString          | 201  |
        | job   | true                        | 201  |
        | job   | false                       | 201  |
