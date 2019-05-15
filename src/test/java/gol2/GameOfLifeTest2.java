package gol2;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:gol2"},
        glue = {"gol2"},
        plugin = {"pretty", "html:target/cucumber"}
)
public class GameOfLifeTest2 {
}