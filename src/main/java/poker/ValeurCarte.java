package poker;

import java.util.stream.Stream;

public enum ValeurCarte {
	DEUX(2, '2'), TROIS(3, '3'), QUATRE(4, '4'), CINQ(5, '5'), SIX(6, '6'), SEPT(7, '7'), HUIT(8, '8'), NEUF(9, '9'),
	DIX(10, 'D'), VALET(11, 'J'), DAME(12, 'Q'), ROI(13, 'K'), AS(14, 'A');

	int valeur;
	char valeurAffichée;

	private ValeurCarte(int valeur, char valeurAffichée) {
		this.valeur = valeur;
		this.valeurAffichée = valeurAffichée;
	}

	public static ValeurCarte of(char valeur) {
		return Stream.of(values()).filter(valeurCarte -> valeurCarte.valeurAffichée == valeur).findFirst().orElse(null);
	}

	@Override
	public String toString() {
		return valeurAffichée + "";
	}
	
	public int getValeur() {
		return valeur;
	}
}
