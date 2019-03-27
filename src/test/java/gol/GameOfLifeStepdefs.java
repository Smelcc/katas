package gol;

import org.assertj.core.api.Assertions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class GameOfLifeStepdefs {
  GameOfLife gameOfLife;
	
  @Given("^Grille (.*)$")
  public void given(String string) throws Throwable {
	  gameOfLife = new GameOfLife(string.split(";"));
  }

  @When("^Itération$")
  public void when() throws Throwable {
	  gameOfLife.iterer();
  }

  @Then("^Le résultat est (.*)$")
  public void then(String résultatEscompté) throws Throwable {
	  String[] situation = gameOfLife.getSituation();
	  Assertions.assertThat(situation).isEqualTo(résultatEscompté.split(";"));
  }

}
