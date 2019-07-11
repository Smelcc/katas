package bowling;

import org.assertj.core.api.Assertions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BowlingStepdefs {

	private PartieBowling partie;
	private String lesCoups;

	@Given("^Score (.*)$")
	public void given(String string) throws Throwable {
		partie = new PartieBowling();
		lesCoups = string;
	}

	@When("^jouer partie$")
	public void when() throws Throwable {
	}

	@Then("^Le résultat est (\\d*)$")
	public void then(int résultatEscompté) throws Throwable {
		int resultat = partie.calculerScore(lesCoups);
		Assertions.assertThat(resultat).isEqualTo(résultatEscompté);
	}

}
