package ppd;

import java.util.ArrayList;
import java.util.List;

public class MathsUtil {

	public static List<Integer> récupérerPlusPetitsDiviseurs(int entier) {
		List<Integer> résultat = new ArrayList<>();
		for (int nb = 2; nb <= entier; ++nb) {
			while (estDivisiblePar(entier, nb)) {
				entier = entier / nb;
				résultat.add(nb);
			}
		}
		return résultat;
	}

	private static boolean estDivisiblePar(int entier, Integer nb) {
		return entier % nb == 0;
	}

}
