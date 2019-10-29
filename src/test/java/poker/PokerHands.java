package poker;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:poker"},
        glue = {"poker"},
        plugin = {"pretty", "html:target/cucumber"}
)
public class PokerHands {
}