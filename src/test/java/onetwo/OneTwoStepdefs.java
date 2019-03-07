package onetwo;

import org.assertj.core.api.Assertions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OneTwoStepdefs {
	OneTwo oneTwo;
	String resultat;
	String parametres;
	
    @Given("^entrée (.*)$")
    public void lesParametresSont(String chiffres) {
    	oneTwo = new OneTwo();
    	parametres = chiffres;
    }

    @When("^transformation$")
    public void transformation() {
        resultat = oneTwo.transformation(parametres);
    }

    @Then("^le résultat est (.*)$")
    public void leResultatEst(String resultatAttendu) {
        Assertions.assertThat(resultat).isEqualTo(resultatAttendu);
    }
}
