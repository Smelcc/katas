package bowling;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:bowling"},
        glue = {"bowling"},
        plugin = {"pretty", "html:target/cucumber"}
)
public class BowlingTest {
}