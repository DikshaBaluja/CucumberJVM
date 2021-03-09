package runners;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Tests",glue={"stepDefinitions"},plugin= {"html:target/site/cucumber-html-report.html","json:target/cucumber.json"},publish=true)
public class TestRunner 
{

}