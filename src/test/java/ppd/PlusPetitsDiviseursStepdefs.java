package ppd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class PlusPetitsDiviseursStepdefs {
	int entier;

	@Given("^nombre (\\d*)$")
	public void lesParametresSont(int nombre) {
		entier = nombre;
	}

	@Then("^la liste attendue est (.*)$")
	public void leResultatEst(String resultatAttendu) {
		List<Integer> resultatEscompté;
		if(resultatAttendu.isEmpty()) {
			resultatEscompté = new ArrayList<>();
		}else {
			resultatEscompté = Stream.of(resultatAttendu.split(" "))
					.map(Integer::valueOf)
					.collect(Collectors.toList());
		}
		List<Integer> plusPetitsDiviseurs = MathsUtil.récupérerPlusPetitsDiviseurs(entier);
		Assertions.assertThat(plusPetitsDiviseurs).isEqualTo(resultatEscompté);
	}
}
