package bowling;

public class PartieBowling {

	public int calculerScore(String lesCoups) {
		String[] tours = lesCoups.split(",");
		boolean cestUnStrikeTourCourant = false;
		boolean cestUnSpareTourCourant = false;
		boolean cestUnStrikeTourPrecedent = false;
		boolean cestUnSparePrecedent = false;
		int resultat = 0;
		int pointsCoup1 = 0;
		int pointsCoup2 = 0;
		String tour = "";
		for (int i = 0; i < tours.length; i++) {
			tour = tours[i].replace('-', '0');
			cestUnStrikeTourCourant = tourEstStrike(tour);
			cestUnSpareTourCourant = ! cestUnStrikeTourCourant && tourEstSpare(tour);
			pointsCoup1 = cestUnStrikeTourCourant ? 10 : getValeurDuCoup(tour.charAt(0));
			pointsCoup2 = cestUnStrikeTourCourant ? 0
					: cestUnSpareTourCourant ? 10 : getValeurDuCoup(tour.charAt(1));
			int pointsCoups = pointsCoup1 + pointsCoup2;
			resultat += pointsCoups > 10 ? 10 : pointsCoups;
			if (cestUnStrikeTourPrecedent) {
				resultat += pointsCoups > 10 ? 10 : pointsCoups;
			}
			if (cestUnSparePrecedent) {
				resultat += pointsCoup1;
			}
			cestUnStrikeTourPrecedent = cestUnStrikeTourCourant;
			cestUnSparePrecedent = cestUnSpareTourCourant;

		}
		return resultat;
	}

	private boolean tourEstStrike(String tour) {
		return tour.charAt(0) == 'X';
	}

	private boolean tourEstSpare(String tour) {
		return tour.charAt(1) == '/';
	}

	private int valeurDuTour(String tour, boolean cestUnStrike, boolean cestUnSpare) {
		tour = tour.replace('-', '0');
		if (tour.charAt(0) == 'X') {
			return 10;
		}
		if (tour.charAt(1) == '/') {
			return 10;
		}
		int pointsCoup1 = getValeurDuCoup(tour.charAt(0));
		int pointsCoup2 = getValeurDuCoup(tour.charAt(1));
		if (cestUnStrike) {
			return 2 * (pointsCoup1 + pointsCoup2);
		}
		if (cestUnSpare) {
			return 2 * pointsCoup1 + pointsCoup2;
		}
		return pointsCoup1 + pointsCoup2;
	}

	private int getValeurDuCoup(char coup) {
		return Character.getNumericValue(coup);
	}

}
