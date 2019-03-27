package gol;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:gol"},
        glue = {"gol"},
        plugin = {"pretty", "html:target/cucumber"}
)
public class GameOfLifeTest {
}