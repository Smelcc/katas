package ppd;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:ppd"},
        glue = {"ppd"},
        plugin = {"pretty", "html:target/cucumber"}
)
public class PlusPetitsDiviseurs {
}