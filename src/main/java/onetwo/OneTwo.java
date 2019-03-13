package onetwo;

import java.util.StringJoiner;
import java.util.stream.Stream;

public class OneTwo {

	public String transformation(String parametres) {
		int compteur = 0;
		String precedent = null;
		StringJoiner resultat = new StringJoiner(" ");
		for (String c : parametres.split(" ")) {
			if (precedent == null || precedent.equals(c)) {
				compteur++;
			} else {
				ajouterValeursAuResultat(compteur, precedent, resultat);
				compteur = 1;
			}
			precedent = c;
		}
		ajouterValeursAuResultat(compteur, precedent, resultat);
		return resultat.toString();
	}

	private void ajouterValeursAuResultat(int compteur, String precedent, StringJoiner resultat) {
		resultat.add(Chiffre.of(compteur));
		resultat.add(determinerChiffreConcerne(precedent));
	}

	private String determinerChiffreConcerne(String parametres) {
		return Chiffre.of(determinerPremierChiffre(parametres));
	}

	private int determinerPremierChiffre(String parametres) {
		return Character.getNumericValue(parametres.charAt(0));
	}

	enum Chiffre {
		un(1), deux(2), trois(3), quatre(4), cinq(5), six(6), sept(7), huit(8), neuf(9);

		int valeur;

		Chiffre(int nombre) {
			valeur = nombre;
		}

		public static String of(int count) {
			return Stream.of(values()).filter(value -> value.valeur == count).findFirst().get().toString();
		}
	}
}
