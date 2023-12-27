package cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions (features ="src/test/java/cucumber",glue="prudhvi.StepDefinitionns",monochrome=true, plugin={"html:target/cucumber.html"})

public class TestNgRunner extends AbstractTestNGCucumberTests {

}
