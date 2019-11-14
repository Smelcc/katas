package poker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Deprecated
public class PokerHandComparator_legacy {
	private static final String EGALITE = "Egalité";
	private static final String JOUEUR1 = "Joueur1";
	private static final String JOUEUR2 = "Joueur2";
	List<Carte> mainJoueur1;
	List<Carte> mainJoueur2;
	final static String GAGNE_AVEC = " gagne avec ";
	final static String UNE_PAIRE_DE = "une paire de ";
	private static final String UNE_DOUBLE_PAIRE_DE = "une double paire de ";

	// TODO refaire le code de CGU!!!!
	public PokerHandComparator_legacy(String mainJoueurUn, String mainJoueurDeux) {
		mainJoueur1 = récupérerMainDepuisChaineDeCaractères(mainJoueurUn);
		mainJoueur2 = récupérerMainDepuisChaineDeCaractères(mainJoueurDeux);
	}

	private List<Carte> récupérerMainDepuisChaineDeCaractères(String mainJoueurUn) {
		return Stream.of(mainJoueurUn.split(",")).map(stringCarte -> new Carte(stringCarte))
				.collect(Collectors.toList());
	}

	public String compare() {
		List<ValeurCarte> listePaireMain1 = valeurPaireOuNulle(mainJoueur1);
		List<ValeurCarte> listePaireMain2 = valeurPaireOuNulle(mainJoueur2);

		String résultat = comparerDoublePaire(listePaireMain1, listePaireMain2);
		if (résultat == null) {
			résultat = comparerPaire(listePaireMain1, listePaireMain2);
		}
		if (résultat == null) {
			résultat = comparerCarte();
		}
		return résultat != null ? résultat : EGALITE;
	}

	private String comparerCarte() {
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
		return null;

	}

	private String comparerDoublePaire(List<ValeurCarte> listePaireMain1, List<ValeurCarte> listePaireMain2) {
		if (joueurADoublePaireGagnante(listePaireMain1, listePaireMain2)) {
			return JOUEUR1 + GAGNE_AVEC + UNE_DOUBLE_PAIRE_DE + récupérerMeilleureValeurCarte(listePaireMain1);
		}

		if (joueurADoublePaireGagnante(listePaireMain2, listePaireMain1)) {
			return JOUEUR2 + GAGNE_AVEC + UNE_DOUBLE_PAIRE_DE + récupérerMeilleureValeurCarte(listePaireMain2);
		}
		return null;
	}

	private boolean joueurADoublePaireGagnante(List<ValeurCarte> listePaireMain1, List<ValeurCarte> listePaireMain2) {
		if (listePaireMain1.size() > 1) {
			if (listePaireMain1.size() > listePaireMain2.size()) {
				return true;
			}
			else if (listePaireMain1.size() == listePaireMain2.size()) {	
				for (int i = 0; i < listePaireMain1.size(); i++) {
					if (listePaireMain1.get(i).getValeur() > listePaireMain2.get(i).getValeur()) {
						return true;
					} 
				}
				
			}
		}
		return false;
	}

	private String comparerPaire(List<ValeurCarte> listePaireMain1, List<ValeurCarte> listePaireMain2) {
		ValeurCarte paireMain1 = listePaireMain1.isEmpty() ? null : listePaireMain1.get(0);
		ValeurCarte paireMain2 = listePaireMain2.isEmpty() ? null : listePaireMain2.get(0);
		if (joueurAPaireGagnante(paireMain1, paireMain2)) {
			return JOUEUR1 + GAGNE_AVEC + UNE_PAIRE_DE + paireMain1.valeur;
		}
		if (joueurAPaireGagnante(paireMain2, paireMain1)) {
			return JOUEUR2 + GAGNE_AVEC + UNE_PAIRE_DE + paireMain2.valeur;
		}
		return null;
	}

	private boolean joueurAPaireGagnante(ValeurCarte paireMain1, ValeurCarte paireMain2) {
		return paireMain1 != null && (paireMain2 == null || paireMain1.valeur > paireMain2.valeur);
	}

	private List<ValeurCarte> valeurPaireOuNulle(List<Carte> mainJoueur1) {
		Collection<ValeurCarte> cartes = mainJoueur1.stream().filter(carte -> mainJoueur1.stream().anyMatch(
				carte2 -> carte2 != carte && carte.getValeurCarte().getValeur() == carte2.getValeurCarte().getValeur()))
				.map(Carte::getValeurCarte).collect(Collectors.toSet());
		List<ValeurCarte> resultat = new ArrayList<ValeurCarte>(cartes);
		resultat.sort(Comparator.reverseOrder());
		return resultat;
	}

	private Carte récupérerMeilleureCarte(List<Carte> mainJoueur) {
		return mainJoueur.stream().max(Carte::compareTo).orElseThrow();
	}

	private ValeurCarte récupérerMeilleureValeurCarte(List<ValeurCarte> mainJoueur) {
		return mainJoueur.stream().max(ValeurCarte::compareTo).orElseThrow();
	}

}