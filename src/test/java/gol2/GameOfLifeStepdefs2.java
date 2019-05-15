package gol2;

import org.assertj.core.api.Assertions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import gol.GameOfLife2;
import cucumber.api.java.en.Then;

public class GameOfLifeStepdefs2 {
  GameOfLife2 gameOfLife;
	
  @Given("^Coordonnée cellule vivante (.*)$")
  public void given(String string) throws Throwable {
	  gameOfLife = new GameOfLife2(string);
  }

  @When("^Itération$")
  public void when() throws Throwable {
	  gameOfLife.iterer();
  }

  @Then("^Le résultat est (.*)$")
  public void then(String résultatEscompté) throws Throwable {
	  String situation = gameOfLife.getResultat();
	  Assertions.assertThat(situation).isEqualTo(résultatEscompté);
  }

}
