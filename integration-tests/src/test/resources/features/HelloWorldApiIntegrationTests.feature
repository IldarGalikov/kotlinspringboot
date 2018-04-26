@HelloWorld
Feature: HelloWorld API endpoint

  Scenario: Get hello message
    Given I POST to endpoint "/apis/v1/hello"
    """
    {
      "username": "Kotlin"
    }
    """
    And the api returns a 201 code
    When a GET request is made to the URI: "/apis/v1/hello"
    Then the api returns a 200 code
    And reponse for JsonSlurper "find{it.username}.username" returns "Kotlin"
