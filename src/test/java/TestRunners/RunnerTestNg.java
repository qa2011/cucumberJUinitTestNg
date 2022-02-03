package TestRunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
 
@RunWith(Cucumber.class) 
@CucumberOptions(features="src\\test\\resources\\features",
					glue = {"StepsDefs"},
					plugin = { "pretty", "html:target/cucumber-reports","json:target/cucumber-reports/Cucumber.json",
							"junit:target/cucumber-reports/Cucumber.xml"},
					monochrome=true)
public class RunnerTestNg extends AbstractTestNGCucumberTests
{
}