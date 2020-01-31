package bus;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:bus"},
        glue = {"bus"},
        plugin = {"pretty", "html:target/cucumber"}
)
public class BusDriverTest {
}