package cucumberRunnerSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

	@CucumberOptions(
	    features = "src\\test\\java\\features",
	    glue = {"StepDef"},
	    tags="@Regression",
	    plugin = {"pretty", "html:target/cucumber-report.html"}
	)
public class RegressionRunner extends AbstractTestNGCucumberTests{

}
