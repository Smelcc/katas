package tennis;

import java.util.stream.Stream;

public class TennisGame {
	private Joueur joueur1;
	private Joueur joueur2;
	
	TennisGame(String nomJoueur1, String nomJoueur2) {
		joueur1 = new Joueur(nomJoueur1);
		joueur2 = new Joueur(nomJoueur2);
	}
	
	private final String GAME = "Game ";
	private final String ADVANTAGE = "Advantage ";

	enum Point {
		LOVE(0, "Love"), FIFTEEN(1, "Fifteen"), THIRTY(2, "Thirty"), FORTY(3, "Forty");

		int score;
		String label;

		private Point(int score, String label) {
			this.score = score;
			this.label = label;
		}

		public static String of(int input) {
			return Stream.of(values()).filter(point -> point.score == input).map(point -> point.label).findFirst()
					.get();
		}

		public String toString() {
			return label;
		}
	}

	public String getScore() {
		if (isScoreDeuce()) {
			return "Deuce";
		}
		if (joueur1.aiJeLAvantageContre(joueur2)) {
			return ADVANTAGE + joueur1.getNom();
		}
		if (joueur2.aiJeLAvantageContre(joueur1)) {
			return ADVANTAGE + joueur2.getNom();
		}
		if (joueur1.aiJeGagnéContre(joueur2)) {
			return GAME + joueur1.getNom();
		}
		if (joueur2.aiJeGagnéContre(joueur1)) {
			return GAME + joueur2.getNom();
		}
		return Point.of(joueur1.getScore()) + " - " + Point.of(joueur2.getScore());
	}

	private boolean isScoreDeuce() {
		return joueur1.getScore() == joueur2.getScore() && joueur1.getScore() > 2;
	}

	public void score(int numéroJoueur) {
		if (numéroJoueur == 1) {
			joueur1.marqueUnPoint();
		} else {
			joueur2.marqueUnPoint();
		}
	}

}
