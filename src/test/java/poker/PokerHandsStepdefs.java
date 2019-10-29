package poker;

import org.assertj.core.api.Assertions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class PokerHandsStepdefs {
	PokerHandComparator pokerHandComparator;
	
	@Given("^entrée \\[(.+)\\], \\[(.+)\\]$")
	public void lesParametresSont(String mainJoueur1, String mainJoueur2) {
		pokerHandComparator = new PokerHandComparator(mainJoueur1, mainJoueur2);
	}

	@Then("^le résultat est (.*)$")
	public void leResultatEst(String resultatAttendu) {
		Assertions.assertThat(pokerHandComparator.compare()).isEqualTo(resultatAttendu);
	}
}
