package bowling;

public class PartieBowling {

	public int calculerScore(String lesCoups) {
		String[] tours = lesCoups.split(",");
		int résultat = 0;
		for (int i = tours.length - 1; i >= 0; i--) {
			if (i == tours.length && tours[i].length() > 2) {
				// TODO yenAmarre -> VGU
			}
			résultat += récupererValeurDuTour(tours[i]);
			if (i > 0) {
				if (leTourPrécedentEstUnSpare(tours, i)) {
					résultat += récupererValeurDuCoup(tours[i].charAt(0));
				} else if (leTourPrécedentEstUnStrike(tours, i)) {
					résultat += récupererValeurDuStrike(tours, i);
				}
			}
		}
		return résultat;
	}

	private int récupererValeurDuStrike(String[] tours, int i) {
		if ("X".equals(tours[i])) {
			return 10 + récupererValeurDuCoup(tours[i + 1].charAt(0));
		}
		return récupererValeurDuTour(tours[i]);
	}

	private boolean leTourPrécedentEstUnSpare(String[] tours, int idx) {
		if (tours[idx - 1].length() == 1) {
			return false;
		}
		return tours[idx - 1].charAt(1) == '/';
	}

	private boolean leTourPrécedentEstUnStrike(String[] tours, int idx) {
		return tours[idx - 1].charAt(0) == 'X';
	}

	private int récupererValeurDuTour(String tour) {
		if (tour.length() == 1) {
			return 10;
		}
		int resultat = récupererValeurDuCoup(tour.charAt(1));
		return (resultat < 10) ? resultat + récupererValeurDuCoup(tour.charAt(0)) : 10;

	}

	private int récupererValeurDuCoup(char coup) {
		if (coup == 'X' || coup == '/') {
			return 10;
		}
		return coup == '-' ? 0 : Character.getNumericValue(coup);
	}

}
