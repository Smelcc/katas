package poker;

public class Carte implements Comparable<Carte> {

	private ValeurCarte valeurCarte;

	public Carte(String carte) {
		this.valeurCarte = ValeurCarte.of(carte.charAt(0));
	}

	public ValeurCarte getValeurCarte() {
		return valeurCarte;
	}

	@Override
	public int compareTo(Carte autreCarte) {
		return this.valeurCarte.valeur - autreCarte.getValeurCarte().getValeur();
	}
	
	@Override
	public String toString() {
		return valeurCarte.toString();
	}
}
