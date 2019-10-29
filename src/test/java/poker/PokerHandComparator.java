package poker;

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
	
	 

	public PokerHandComparator(String mainJoueurUn, String mainJoueurDeux) {
		mainJoueur1 = récupérerMainDepuisChaineDeCaractères(mainJoueurUn);
		mainJoueur2 = récupérerMainDepuisChaineDeCaractères(mainJoueurDeux);
	}

	private List<Carte> récupérerMainDepuisChaineDeCaractères(String mainJoueurUn) {
		return Stream.of(mainJoueurUn.split(",")).map(stringCarte -> new Carte(stringCarte))
				.collect(Collectors.toList());
	}

	public String compare() {
		boolean paireMain1 = false;
		for (Carte carte: mainJoueur1) {
			for(Carte carte2: mainJoueur1) {
				if (carte2 != carte && carte2.getValeurCarte().getValeur() == carte.getValeurCarte().getValeur()) {
					paireMain1 = true;
				}
			}
		}

		// TODO HAKIM
		boolean paireMain2 = false;
		for (Carte carte: mainJoueur2) {
			for(Carte carte2: mainJoueur2) {
				if (carte2 != carte && carte2.getValeurCarte().getValeur() == carte.getValeurCarte().getValeur()) {
					paireMain2 = true;
				}
			}
		}
		
		if (paireMain1 && ! paireMain2) {
			return JOUEUR1 + GAGNE_AVEC + "une paire";
		} else if (paireMain2 && ! paireMain1) {
			return JOUEUR2 + GAGNE_AVEC + "une paire";
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

	private Carte récupérerMeilleureCarte(List<Carte> mainJoueur) {
		return mainJoueur.stream().max(Carte::compareTo).orElseThrow();
	}

}
