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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((valeurCarte == null) ? 0 : valeurCarte.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carte other = (Carte) obj;
		if (valeurCarte != other.valeurCarte)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return valeurCarte.toString();
	}
}
