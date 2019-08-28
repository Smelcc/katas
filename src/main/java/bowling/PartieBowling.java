package bowling;

public class PartieBowling {

	public int calculerScore(String lesCoups) {
		String[] tours = lesCoups.split(",");
		int resultat = 0;
		for (int i = tours.length - 1; i >= 0; i--) {
			resultat += valeurDuTour(tours[i]);
		}
		return resultat;
	}

	private int valeurDuTour(String tour) {
		tour = tour.replace('-', '0');
		if (tour.charAt(0) == 'X') {
			return 10;
		}
		if (tour.charAt(1) == '/') {
			return 10;
		}
		return getValeurDuCoup(tour.charAt(0)) + getValeurDuCoup(tour.charAt(1));
	}

	private int getValeurDuCoup(char coup) {
		return Character.getNumericValue(coup);
	}

}
