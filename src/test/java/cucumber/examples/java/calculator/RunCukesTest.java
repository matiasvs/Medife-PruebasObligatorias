package cucumber.examples.java.calculator;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
//import org.testng.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/cucumber-report.json"},
features="src/test/resources/cucumber/examples/java/calculator")
public class RunCukesTest {
    
}