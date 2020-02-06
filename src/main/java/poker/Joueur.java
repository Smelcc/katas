package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Joueur {

	private String nom;
	private List<Carte> main;

	public List<Carte> getMain() {
		return main;
	}

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

	public Carte getCarte(int index) {
		return main.get(index);
	}

	public Joueur compareTo(Joueur joueur2) {
		Joueur gagnant = comparerCarré(joueur2);
		if (gagnant == null) {
			gagnant = comparerFull(joueur2);
		}
		if (gagnant == null) {
			gagnant = comparerSuite(joueur2);
		}
		if (gagnant == null) {
			gagnant = comparerBrelan(joueur2);
		}
		if (gagnant == null) {
			gagnant = comparerNombreDePaires(joueur2);
		}
		if (gagnant == null) {
			gagnant = comparerPaires(joueur2);
		}
		if (gagnant == null) {
			gagnant = comparerCarteLaPlusForte(joueur2);
		}
		return gagnant;
	}

	private Joueur comparerCarré(Joueur joueur2) {
		return déterminerVainqueur(joueur2, Combinaison.CARRE);
	}

	private Joueur comparerSuite(Joueur joueur2) {
		return déterminerVainqueur(joueur2, Combinaison.SUITE);
	}

	private Joueur comparerFull(Joueur joueur2) {
		return déterminerVainqueur(joueur2, Combinaison.FULL);
	}

	private Joueur comparerBrelan(Joueur joueur2) {
		return déterminerVainqueur(joueur2, Combinaison.BRELAN);
	}

	private Joueur déterminerVainqueur(Joueur joueur2, Combinaison combinaisonCarte) {
		Function<List<Carte>, ValeurCarte> règleAAppliquer = combinaisonCarte.getRègleAAppliquer();
		ValeurCarte valeurCarteJoueur1 = règleAAppliquer.apply(main);
		ValeurCarte valeurCarteJoueur2 = règleAAppliquer.apply(joueur2.getMain());
		if (valeurCarteJoueur1 != null && valeurCarteJoueur2 != null) {
			return valeurCarteJoueur1.compareTo(valeurCarteJoueur2) > 0 ? this : joueur2;
		}
		if (valeurCarteJoueur1 != null)
			return this;
		if (valeurCarteJoueur2 != null)
			return joueur2;
		return null;
	}

	public String récupérerCombinaisonLaPlusForte() {
		ValeurCarte carré = Combinaison.CARRE.getRègleAAppliquer().apply(main);
		if (carré != null) {
			return "un carré de " + carré;
		}
		ValeurCarte full = Combinaison.FULL.getRègleAAppliquer().apply(main);
		if (full != null) {
			Carte paire = main.stream().filter(carte -> !carte.getValeurCarte().equals(full)).findAny().orElse(null);
			return "un full de " + full + " par " + paire.getValeurCarte();
		}
		ValeurCarte suite = Combinaison.SUITE.getRègleAAppliquer().apply(main);
		if (suite != null) {
			return "une suite au " + suite;
		}
		ValeurCarte brelan = Combinaison.BRELAN.getRègleAAppliquer().apply(main);
		if (brelan != null)
			return "un brelan de " + brelan;
		List<ValeurCarte> paires = Combinaison.PAIRES.getRègleAAppliquer().apply(main);;
		if (paires.size() == 2)
			return "une double paire de " + paires.get(0);
		if (paires.size() == 1)
			return "une paire de " + paires.get(0);
		return main.get(0) + "";
	}

	private Joueur comparerCarteLaPlusForte(Joueur joueur2) {
		for (int i = 0; i < main.size(); i++) {
			int comparaison = main.get(i).compareTo(joueur2.getCarte(i));
			if (comparaison > 0) {
				return this;
			}
			if (comparaison < 0) {
				return joueur2;
			}
		}
		return null;
	}

	public boolean carteEgale(Carte carte) {
		return main.stream().anyMatch(carte2 -> carte2 != carte && carte2.compareTo(carte) == 0);
	}

	private Joueur comparerNombreDePaires(Joueur joueur2) {
		List<ValeurCarte> paires = récupérerPaires();
		List<ValeurCarte> pairesJoueur2 = joueur2.récupérerPaires();
		if (paires.size() > pairesJoueur2.size()) {
			return this;
		}
		if (paires.size() < pairesJoueur2.size()) {
			return joueur2;
		}
		return null;
	}

	private Joueur comparerPaires(Joueur joueur2) {
		List<ValeurCarte> paires = récupérerPaires();
		List<ValeurCarte> pairesJoueur2 = joueur2.récupérerPaires();
		if (paires.size() == pairesJoueur2.size()) {
			int sommeJoueur1 = sommeValeurCartes(paires);
			int sommeJoueur2 = sommeValeurCartes(pairesJoueur2);
			if (sommeJoueur1 > sommeJoueur2) {
				return this;
			} else if (sommeJoueur1 < sommeJoueur2) {
				return joueur2;
			}
		}
		if (paires.size() > 0) {
			int comparaison = paires.get(0).compareTo(pairesJoueur2.get(0));
			if (comparaison > 0) {
				return this;
			}
			if (comparaison < 0) {
				return joueur2;
			}
		}
		return null;
	}

	private int sommeValeurCartes(List<ValeurCarte> cartes) {
		return cartes.stream().mapToInt(ValeurCarte::getValeur).sum();
	}

}
