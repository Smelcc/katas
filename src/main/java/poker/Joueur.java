package poker;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// TODO Hakim ou Abdul
public class Joueur {

	private String nom;
	private List<Carte> main;
	private String conditionGagnante;

	public Joueur(String nomJoueur) {
		nom = nomJoueur;
	}

	public void setMain(List<Carte> mainJoueur) {
		mainJoueur.sort(Comparator.reverseOrder());
		main = mainJoueur;
	}

	public String getNom() {
		return nom;
	}

	public String getConditionVictoire() {
		return conditionGagnante;
	}

	public Carte getCarte(int index) {
		return main.get(index);
	}

	public Joueur compareTo(Joueur joueur2) {
		Joueur gagnant = comparerNombreDePaires(joueur2);
		if (gagnant == null) {
			gagnant = comparerPaires(joueur2);
		}
		if (gagnant == null) {
			gagnant = comparerCarteLaPlusForte(joueur2);
		}
		return gagnant;
	}

	private Joueur comparerCarteLaPlusForte(Joueur joueur2) {
		for (int i = 0; i < main.size(); i++) {
			int comparaison = main.get(i).compareTo(joueur2.getCarte(i));
			if (comparaison > 0) {
				conditionGagnante = main.get(i).getValeurCarte().toString();
				return this;
			}
			if (comparaison < 0) {
				joueur2.conditionGagnante = joueur2.getCarte(i).getValeurCarte().toString();
				return joueur2;
			}
		}
		return null;
	}
	
	private List<ValeurCarte> récupérerPaires(){
		Set<ValeurCarte> paires = main.stream()
		.filter(this::carteEgale)
		.map(Carte::getValeurCarte)
		.collect(Collectors.toSet());
		return paires.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	}

	private boolean carteEgale(Carte carte) {
		return main.stream().anyMatch(carte2 -> carte2 != carte && carte2.compareTo(carte) == 0);
	}
	
	private Joueur comparerNombreDePaires(Joueur joueur2) {
		List<ValeurCarte> paires = récupérerPaires();
		List<ValeurCarte> pairesJoueur2 = joueur2.récupérerPaires();
		if (paires.size() > pairesJoueur2.size()) {
			conditionGagnante = "une paire de " + paires.get(0).toString();
			return this;
		}
		if (paires.size() < pairesJoueur2.size()) {
			joueur2.conditionGagnante = "une paire de " + pairesJoueur2.get(0).toString();
			return joueur2;
		}
		return null;
	}
	
	private Joueur comparerPaires(Joueur joueur2) {
		List<ValeurCarte> paires = récupérerPaires();
		List<ValeurCarte> pairesJoueur2 = joueur2.récupérerPaires();
		if (paires.size() > 0) {
			int comparaison = paires.get(0).compareTo(pairesJoueur2.get(0));
			if (comparaison > 0) {
				conditionGagnante = "une paire de " + paires.get(0).toString();
				return this;
			}
			if (comparaison < 0) {
				joueur2.conditionGagnante = "une paire de " + pairesJoueur2.get(0).toString();
				return joueur2;
			}
		}
		
		return null;
	}


}
