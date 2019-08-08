package jake.test.ui.cucumber.runner

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@CucumberOptions(
  features = Array("src/test/resources/features"),
  glue = Array("jake.test.ui.cucumber.stepdefs"),
  plugin = Array ("pretty", "html:target/cucumber", "json:target/cucumber.json"),
  tags = Array("@Example")
)
class Runner {}
