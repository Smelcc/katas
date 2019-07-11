package bowling;

public class PartieBowling {

	public int calculerScore(String lesCoups) {
		if (lesCoups.contains("/")) {
			int coupRéussi = lesCoups.chars()
					.filter(coup -> coup != ',')
					.filter(coup -> coup != '-')
					.map(Character::getNumericValue)
					.findFirst()
					.orElse(0);
			return 10 + coupRéussi;
		}
		return lesCoups.chars()
				.filter(coup -> coup != ',')
				.filter(coup -> coup != '-')
				.map(Character::getNumericValue)
				.sum();
	}

}
