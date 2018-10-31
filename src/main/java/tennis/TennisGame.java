package tennis;

import java.util.stream.Stream;

public class TennisGame {
	private int scoreA = 0;
	private int scoreB = 0;

	enum Point {
		LOVE(0, "Love"), FIFTEEN(1, "Fifteen"), THIRTY(2, "Thirty"), FORTY(3, "Forty"), ADVANTAGE(4, "Advantage"),
		GAME(5, "Game");

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
		if (isAdvantageMauresmo()) {
			return Point.ADVANTAGE + " Mauresmo";
		}
		if (isScoreGagnant(scoreA)) {
			return Point.GAME + " Mauresmo";
		}
		if (isScoreGagnant(scoreB)) {
			return Point.GAME + " Pierce";
		}
		return Point.of(scoreA) + " - " + Point.of(scoreB);
	}

	private boolean isAdvantageMauresmo() {
		return (scoreA >= 3 && scoreB >= 3 && scoreA > scoreB);
	}

	private boolean isScoreDeuce() {
		return scoreA == scoreB && scoreA > 2;
	}

	private boolean isScoreGagnant(int score) {
		return score > 3;
	}

	public void score(int numéroJoueur) {
		if (numéroJoueur == 1) {
			scoreA++;
		} else {
			scoreB++;
		}
	}

}
