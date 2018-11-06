package tennis;

public class Joueur {
	public Joueur(String nomJoueur) {
		nom = nomJoueur;
	}

	private String nom;
	private int score = 0;

	public String getNom() {
		return nom;
	}

	public int getScore() {
		return score;
	}

	public void marqueUnPoint() {
		score++;
	}

	public boolean aiJeGagnéContre(Joueur adversaire) {
		return score > 3 && score > adversaire.getScore() + 1;
	}

	public boolean aiJeLAvantageContre(Joueur adversaire) {
		return (score >= 3 && adversaire.getScore() >= 3 && score == adversaire.getScore() + 1);
	}
}
