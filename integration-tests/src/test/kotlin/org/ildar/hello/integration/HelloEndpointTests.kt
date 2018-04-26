package org.ildar.hello.integration

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.http.ContentType
import io.restassured.response.ExtractableResponse
import io.restassured.specification.RequestSpecification
import org.hamcrest.Matchers.contains
import org.ildar.SpringKotlinHelloWorldApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.ContextConfiguration
import javax.annotation.PostConstruct
import org.assertj.core.api.Assertions.assertThat


@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = [SpringKotlinHelloWorldApplication::class])
@ContextConfiguration(classes = [SpringKotlinHelloWorldApplication::class])
class HelloEndpointTests {
    private val JSON_API_CONTENT_TYPE = "application/vnd.api+json"

    @LocalServerPort
    lateinit var randomServerPort: Integer
    lateinit var requestSpecification: RequestSpecification

    private var response: ExtractableResponse<*>? = null

    @PostConstruct
    fun setup() {
        requestSpecification = RequestSpecBuilder()
                .setContentType(ContentType.fromContentType(JSON_API_CONTENT_TYPE))
                .setBaseUri("http://localhost:$randomServerPort")
                .build()
    }

    @When("^a GET request is made to the URI: \"([^\"]*)\"$")
    fun getFromURL(url: String) {
        response = RestAssured
                .given()
                .log().all()
                .spec(requestSpecification)
                .`when`().get(url)
                .then().extract()
    }

    @Given("I POST to endpoint \"([^\"]*)\"")
    fun postJSON(uri: String, requestBody: String) {
        response = RestAssured
                .given()
                .spec(requestSpecification)
                .body(requestBody)
                .`when`().post(uri)
                .then().extract()
    }

    @And("^reponse for JsonSlurper \"([^\"]*)\" returns \"([^\"]*)\"$")
    fun responseIsCorrect(jsonSlurper: String, value: String) {
        assertThat(response?.jsonPath()?.get<String>(jsonSlurper)).isEqualTo(value)
    }

    @And("^the api returns a (\\d+) code$")
    fun responseStatusIsCorrect(status: Int) {
        assertThat(response?.statusCode())
                .isEqualTo(status)
    }
}
