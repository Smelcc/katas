package bus;

import org.assertj.core.api.Assertions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class BusDriverStepDefs {

	private CaNousInteresseGrave busDriver = new CaNousInteresseGrave();

	@Given("^Un chauffeur avec pour route (\\d+)$")
	public void ajouterChauffeur(String route) {
		busDriver.ajouterChauffeur(route);
	}

	@When("^Il termine son parcours$")
	public void faireLeParcours() {
	}

	@Then("^Il a tous les ragots au (\\d+) arrêt$")
	public void nombreIteration(int iteration) {
		Assertions.assertThat(busDriver.getNombreIteration()).isEqualTo(iteration);
	}

	@Then("^Ils n'ont pas tous les ragots$")
	public void nombreIteration() {
		Assertions.assertThat(busDriver.getNombreIteration()).isEqualTo(0);
	}
}
