package cucumberRunnerSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

	@CucumberOptions(
	    features = "src\\test\\java\\features",
	    glue = {"StepDef"},
	    tags="@InvalidLogin",
	    plugin = {"pretty", "html:target/cucumber-report.html"}
	)
public class InvalidLoginRunner extends AbstractTestNGCucumberTests{

}