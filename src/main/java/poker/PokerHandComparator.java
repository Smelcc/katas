package poker;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PokerHandComparator {

	private static final String EGALITE = "Egalité";
	Joueur joueur1 = new Joueur("Joueur1");
	Joueur joueur2 = new Joueur("Joueur2");
	
	public PokerHandComparator(String mainJoueur1, String mainJoueur2) {
		joueur1.setMain(récupérerMainDepuisChaineDeCaractères(mainJoueur1));
		joueur2.setMain(récupérerMainDepuisChaineDeCaractères(mainJoueur2));
	}

	public String compare() {
		 Joueur vainqueur = joueur1.compareTo(joueur2);
		 return vainqueur == null ? EGALITE 
				 : vainqueur.getNom() + " gagne avec " + vainqueur.getConditionVictoire();
	}

	private List<Carte> récupérerMainDepuisChaineDeCaractères(String mainJoueurUn) {
		return Stream.of(mainJoueurUn.split(",")).map(stringCarte -> new Carte(stringCarte))
				.collect(Collectors.toList());
	}
}
