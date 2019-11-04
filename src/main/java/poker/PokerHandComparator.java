package poker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PokerHandComparator {
	private static final String EGALITE = "Egalité";
	private static final String JOUEUR1 = "Joueur1";
	private static final String JOUEUR2 = "Joueur2";
	List<Carte> mainJoueur1;
	List<Carte> mainJoueur2;
	final static String GAGNE_AVEC = " gagne avec ";
	final static String UNE_PAIRE_DE = "une paire de ";
	private static final String UNE_DOUBLE_PAIRE_DE = "une double paire de ";

	// TODO refaire le code de CGU!!!!
	public PokerHandComparator(String mainJoueurUn, String mainJoueurDeux) {
		mainJoueur1 = récupérerMainDepuisChaineDeCaractères(mainJoueurUn);
		mainJoueur2 = récupérerMainDepuisChaineDeCaractères(mainJoueurDeux);
	}

	private List<Carte> récupérerMainDepuisChaineDeCaractères(String mainJoueurUn) {
		return Stream.of(mainJoueurUn.split(",")).map(stringCarte -> new Carte(stringCarte))
				.collect(Collectors.toList());
	}

	public String compare() {
		List<ValeurCarte> listePaireMain1 = valeurPaireOuNull(mainJoueur1);
		List<ValeurCarte> listePaireMain2 = valeurPaireOuNull(mainJoueur2);

		if (listePaireMain1.size() > 1 && listePaireMain1.size() > listePaireMain2.size()) {
			return JOUEUR1 + GAGNE_AVEC + UNE_DOUBLE_PAIRE_DE
					+ listePaireMain1.stream().max(Comparator.naturalOrder()).get();
		}

		if (listePaireMain2.size() > 1 && listePaireMain2.size() > listePaireMain1.size()) {
			return JOUEUR2 + GAGNE_AVEC + UNE_DOUBLE_PAIRE_DE
					+ listePaireMain2.stream().max(Comparator.naturalOrder()).get();
		}

		ValeurCarte paireMain1 = listePaireMain1.isEmpty() ? null : listePaireMain1.get(0);
		ValeurCarte paireMain2 = listePaireMain2.isEmpty() ? null : listePaireMain2.get(0);

		if (paireMain1 != null && paireMain2 == null) {
			return JOUEUR1 + GAGNE_AVEC + UNE_PAIRE_DE + paireMain1.valeur;
		}
		if (paireMain2 != null && paireMain1 == null) {
			return JOUEUR2 + GAGNE_AVEC + UNE_PAIRE_DE + paireMain2.valeur;
		}
		if (paireMain1 != null && paireMain2 != null) {
			if (paireMain1.valeur > paireMain2.valeur) {
				return JOUEUR1 + GAGNE_AVEC + UNE_PAIRE_DE + paireMain1.valeur;
			}
			if (paireMain2.valeur > paireMain1.valeur) {
				return JOUEUR2 + GAGNE_AVEC + UNE_PAIRE_DE + paireMain2.valeur;
			}
		}

		Carte meilleureCarteJoueur1, meilleureCarteJoueur2;
		do {
			meilleureCarteJoueur1 = récupérerMeilleureCarte(mainJoueur1);
			meilleureCarteJoueur2 = récupérerMeilleureCarte(mainJoueur2);
			if (meilleureCarteJoueur1.compareTo(meilleureCarteJoueur2) > 0) {
				return JOUEUR1 + GAGNE_AVEC + meilleureCarteJoueur1.getValeurCarte();
			} else if (meilleureCarteJoueur2.compareTo(meilleureCarteJoueur1) > 0) {
				return JOUEUR2 + GAGNE_AVEC + meilleureCarteJoueur2.getValeurCarte();
			}
			mainJoueur1.remove(meilleureCarteJoueur1);
			mainJoueur2.remove(meilleureCarteJoueur2);

		} while (!mainJoueur1.isEmpty() && !mainJoueur2.isEmpty());
		return EGALITE;
	}

	private List<ValeurCarte> valeurPaireOuNull(List<Carte> mainJoueur1) {
		Collection set = mainJoueur1.stream().filter(carte -> mainJoueur1.stream().anyMatch(
				carte2 -> carte2 != carte && carte.getValeurCarte().getValeur() == carte2.getValeurCarte().getValeur()))
				.map(Carte::getValeurCarte).collect(Collectors.toSet());
		return new ArrayList(set);
	}

	private Carte récupérerMeilleureCarte(List<Carte> mainJoueur) {
		return mainJoueur.stream().max(Carte::compareTo).orElseThrow();
	}

}