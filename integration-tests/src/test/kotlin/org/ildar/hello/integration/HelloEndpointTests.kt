package org.ildar.hello.integration

import cucumber.api.java.en.And
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import org.ildar.SpringKotlinHelloWorldApplication
import org.springframework.boot.context.embedded.LocalServerPort
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = arrayOf(SpringKotlinHelloWorldApplication::class))
@ContextConfiguration(classes = arrayOf(SpringKotlinHelloWorldApplication::class))

class HelloEndpointTests{

    @LocalServerPort
    private var randomServerPort: Int = 0

    @When("^a GET request is made to the URI: \"([^\"]*)\"$")
    fun makeRequest(url: String){
        println("Hello Cucumber: " + url)
    }

    @Then("^the api returns a (\\d\\d\\d) code$")
    fun checkResponseStatusCode(code: Int){
        println("Hello Cucumber: " + code)
    }
    @And("^reponse is correct$")
    fun responseIsCorrect(){
        println("it is correct")
    }
}
