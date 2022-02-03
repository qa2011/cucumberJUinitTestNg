package TestRunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class) 
@CucumberOptions(features="src\\test\\resources\\features",
					glue = {"StepsDefs"},
					plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
					monochrome=true)
public class RunnerJunit
{
}