package lcd;

import java.util.List;

public class NumberToLCD {

	public static List<String> convertirEnLCD(int nombre) {
		List<String> resultat = List.of("", "", "");
		do {
			List<String> chiffreDeDroite = NombreLCD.of(nombre % 10);
			nombre = retirerChiffreDeDroite(nombre);
			resultat = ajouterChiffre(chiffreDeDroite, resultat);
		} while (nombre > 0);
		return resultat;
	}

	private static int retirerChiffreDeDroite(int nombre) {
		return nombre / 10;
	}

	private static List<String> ajouterChiffre(List<String> chiffre, List<String> resultat) {
		return List.of(chiffre.get(0) + resultat.get(0), chiffre.get(1) + resultat.get(1),
				chiffre.get(2) + resultat.get(2));
	}

}
