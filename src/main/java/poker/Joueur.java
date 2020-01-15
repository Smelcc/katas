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
		ValeurCarte carréJoueur1 = récupérerCarré();
		ValeurCarte carréJoueur2 = joueur2.récupérerCarré();
		if (carréJoueur1 != null && carréJoueur2 != null) {
			return carréJoueur1.compareTo(carréJoueur2) > 0 ? this : joueur2;
		}
		if (carréJoueur1 != null)
			return this;
		if (carréJoueur2 != null)
			return joueur2;
		return null;
	}

	private Joueur comparerSuite(Joueur joueur2) {
		ValeurCarte suiteJoueur1 = récupérerSuite();
		ValeurCarte suiteJoueur2 = joueur2.récupérerSuite();
		if (suiteJoueur1 != null && suiteJoueur2 == null) {
			return this;
		} else if (suiteJoueur1 == null && suiteJoueur2 != null) {
			return joueur2;
		} else if (suiteJoueur1 != null && suiteJoueur2 != null) {
			return suiteJoueur1.compareTo(suiteJoueur2) > 0 ? this : joueur2;
		}
		return null;
	}

	private ValeurCarte récupérerSuite() {
		List<Carte> copieDeMain = new ArrayList<>(main);
		if (estCarteAs(copieDeMain.get(0)))
			if (estCarteDeux(copieDeMain.get(copieDeMain.size() - 1)))
				déplacerAsEnPetitePosition(copieDeMain);

		for (int i = 1; i < copieDeMain.size(); i++) {
			if (!isSuite(copieDeMain.get(i), copieDeMain.get(i - 1))) {
				return null;
			}
		}
		main = copieDeMain;
		return main.get(0).getValeurCarte();
	}

	private boolean estCarteDeux(Carte carte) {
		return ValeurCarte.DEUX.equals(carte.getValeurCarte());
	}

	private boolean estCarteAs(Carte carte) {
		return ValeurCarte.AS.equals(carte.getValeurCarte());
	}

	private void déplacerAsEnPetitePosition(List<Carte> copieDeMain) {
		copieDeMain.add(copieDeMain.size(), copieDeMain.get(0));
		copieDeMain.remove(0);
	}

	private boolean isSuite(Carte carteBasse, Carte carteHaute) {
		if (estCarteAs(carteBasse)) {
			return estCarteDeux(carteHaute);
		}
		return carteBasse.getValeurCarte().getValeur() - carteHaute.getValeurCarte().getValeur() == -1;
	}

	private Joueur comparerFull(Joueur joueur2) {
		ValeurCarte fullJoueur1 = récupérerFull();
		ValeurCarte fullJoueur2 = joueur2.récupérerFull();
		if (fullJoueur1 != null && fullJoueur2 == null) {
			return this;
		} else if (fullJoueur1 == null && fullJoueur2 != null) {
			return joueur2;
		} else if (fullJoueur1 != null && fullJoueur2 != null) {
			return fullJoueur1.compareTo(fullJoueur2) > 0 ? this : joueur2;
		}
		return null;
	}

	private ValeurCarte récupérerFull() {
		ValeurCarte valeurBrelan = récupérerBrelan();
		if (valeurBrelan != null) {
			List<Carte> mainsSansBrelan = main.stream().filter(e -> !e.getValeurCarte().equals(valeurBrelan))
					.collect(Collectors.toList());
			List<ValeurCarte> paires = récupérerPaires(mainsSansBrelan);
			if (!paires.isEmpty()) {
				return valeurBrelan;
			}
		}
		return null;
	}

	private Joueur comparerBrelan(Joueur joueur2) {
		return déterminerVainqueur(joueur2, Joueur::récupérerBrelan);
	}

	private Joueur déterminerVainqueur(Joueur joueur2, Function<Joueur, ValeurCarte> règleAAppliquer) {
		ValeurCarte valeurCarteJoueur1 = règleAAppliquer.apply(this);
		ValeurCarte valeurCarteJoueur2 = règleAAppliquer.apply(joueur2);
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
		ValeurCarte carré = récupérerCarré();
		if (carré != null) {
			return "un carré de " + carré;
		}
		ValeurCarte full = récupérerFull();
		if (full != null) {
			Carte paire = main.stream().filter(carte -> !carte.getValeurCarte().equals(full)).findAny().orElse(null);
			return "un full de " + full + " par " + paire.getValeurCarte();
		}
		ValeurCarte suite = récupérerSuite();
		if (suite != null) {
			return "une suite au " + suite;
		}
		ValeurCarte brelan = récupérerBrelan();
		if (brelan != null)
			return "un brelan de " + brelan;
		List<ValeurCarte> paires = récupérerPaires();
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

	private ValeurCarte récupérerCarré() {
		List<ValeurCarte> valeursDeLaMain = main.stream().map(Carte::getValeurCarte).collect(Collectors.toList());
		return Stream.of(ValeurCarte.values()).filter(value -> Collections.frequency(valeursDeLaMain, value) == 4)
				.findFirst().orElse(null);
	}

	private List<ValeurCarte> récupérerPaires(List<Carte> cartes) {
		Set<ValeurCarte> paires = cartes.stream().filter(this::carteEgale).map(Carte::getValeurCarte)
				.collect(Collectors.toSet());
		return paires.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	}

	private List<ValeurCarte> récupérerPaires() {
		Set<ValeurCarte> paires = main.stream().filter(this::carteEgale).map(Carte::getValeurCarte)
				.collect(Collectors.toSet());
		return paires.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	}

	private ValeurCarte récupérerBrelan() {
		List<ValeurCarte> valeursDeLaMain = main.stream().map(Carte::getValeurCarte).collect(Collectors.toList());
		return Stream.of(ValeurCarte.values()).filter(value -> Collections.frequency(valeursDeLaMain, value) == 3)
				.findFirst().orElse(null);
	}

	private boolean carteEgale(Carte carte) {
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
