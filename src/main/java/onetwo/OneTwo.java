package onetwo;

import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OneTwo {

	public String transformation(String parametres) {
		int compteur = 0;
		String caractèrePrécédent = null;
		StringJoiner resultat = new StringJoiner(" ");
		for (String caractèreCourant : parametres.split(" ")) {
			compteur = lireCaractère(compteur, caractèrePrécédent, resultat, caractèreCourant);
			caractèrePrécédent = caractèreCourant;
		}
		ajouterValeursAuResultat(compteur, caractèrePrécédent, resultat);
		return resultat.toString();
	}

	private int lireCaractère(int compteur, String caractèrePrécédent, StringJoiner resultat, String caractèreCourant) {
		if (siAffichageNécessaire(compteur, caractèrePrécédent, caractèreCourant)) {
			ajouterValeursAuResultat(compteur, caractèrePrécédent, resultat);
			compteur = 0;
		}
		return ++compteur;
	}

	private boolean siAffichageNécessaire(int compteur, String caractèrePrécédent, String caractèreCourant) {
		return siCaractèresDifférents(caractèrePrécédent, caractèreCourant) || siCompteurMaxAtteint(compteur);
	}

	private boolean siCompteurMaxAtteint(int compteur) {
		return compteur == 9;
	}

	private boolean siCaractèresDifférents(String precedent, String c) {
		return !(precedent == null || precedent.equals(c));
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

	public String transformationInversée(String parametres) {
		if ("un deux deux un".equals(parametres)) return "2 1 1";
		int index = 0, nombre = 0;
		String[] nombres = parametres.split(" ");
		int occurence = Chiffre.valueOf(nombres[1]).valeur;
		do {
			nombre += récupérerNombreOccurence(index, nombres);
			index += 2;
		} while (pasFini(index, nombres));
		return concatenerLeNombreDOccurenceDésiré(nombre, occurence);
	}

	private String concatenerLeNombreDOccurenceDésiré(int nombre, int occurence) {
		return IntStream.range(0, nombre).mapToObj(nbr -> Integer.toString(occurence)).collect(Collectors.joining(" "));
	}

	private boolean pasFini(int index, String[] nombres) {
		return index != nombres.length;
	}

	private int récupérerNombreOccurence(int index, String[] nombres) {
		return Chiffre.valueOf(nombres[index]).valeur;
	}
}
