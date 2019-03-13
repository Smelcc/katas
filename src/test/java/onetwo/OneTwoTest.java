package onetwo;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:onetwo"},
        glue = {"onetwo"},
        plugin = {"pretty", "html:target/cucumber"}
)
public class OneTwoTest {
}