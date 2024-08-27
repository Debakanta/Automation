Feature: User creation with response validation

   Scenario: New User addition with job
    When User calls users api with post http request
    Then User should get the response code as 201
    And User should have name in resoponse 
    And User should have job in resoponse
    And User should have id in resoponse
    And User should have createdAt in resoponse
    But User should not get response code otherthan 201