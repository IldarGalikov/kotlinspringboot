
import cucumber.api.CucumberOptions

@CucumberOptions(
        features = arrayOf("src/test/resources/features"),
        glue = arrayOf("org.ildar.hello.integration"),
        plugin = arrayOf("json:build/output/cucumber/cucumber.json")
)
class CucumberTest
