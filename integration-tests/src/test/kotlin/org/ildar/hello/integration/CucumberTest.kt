package org.ildar.hello.integration
import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@RunWith(Cucumber::class)
@CucumberOptions(

        features = ["src/test/resources/features"],
        glue = ["org.ildar.hello.integration"]
        )
class CucumberTest
