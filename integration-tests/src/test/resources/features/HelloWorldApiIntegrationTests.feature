@HelloWorld
Feature: HelloWorld api endpoint

  Scenario: Get hello message
    When a GET request is made to the URI: "/apis/v1/hello"
    Then the api returns a 200 code
    And reponse is correct
