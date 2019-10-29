package lcd;

import java.util.List;
import java.util.stream.Collectors;

public class NumberToLCD {

	public static List<String> convertirEnLCD(int valeurEntière, int hauteur, int largeur) {
		List<String> résultatMaGueule = convertirEnLCD(valeurEntière);
		if (hauteur > 1) {
			résultatMaGueule = aggrandirLeToutPitiLCD(hauteur, résultatMaGueule);
		}
		if (largeur > 1) {
			résultatMaGueule = élargirLeToutPitiLCDQuiADéjàPeutÊtreEtéAggrandiLigneOnze(largeur, résultatMaGueule);
		}
		return résultatMaGueule;
	}

	private static List<String> élargirLeToutPitiLCDQuiADéjàPeutÊtreEtéAggrandiLigneOnze(int largeur,
			List<String> résultatMaGueule) {
		return résultatMaGueule.stream().map(ligne -> élargirLaLigne(largeur, ligne)).collect(Collectors.toList());
	}

	private static String élargirLaLigne(int largeur, String ligne) {
		return ligne.charAt(0) + ligne.substring(1, 2).repeat(largeur) + ligne.charAt(2);
	}

	private static int calculerLaHauteurDuLCD(int hauteur) {
		return hauteur * 2 + 3;
	}

	public static List<String> convertirEnLCD(int nombre) {
		List<String> résultat = List.of("", "", "");
		do {
			List<String> chiffreDeDroite = NombreLCD.of(nombre % 10);
			nombre = retirerChiffreDeDroite(nombre);
			résultat = ajouterChiffre(chiffreDeDroite, résultat);
		} while (nombre > 0);
		return résultat;
	}

	private static int retirerChiffreDeDroite(int nombre) {
		return nombre / 10;
	}

	private static List<String> ajouterChiffre(List<String> chiffre, List<String> resultat) {
		return List.of(chiffre.get(0) + resultat.get(0), chiffre.get(1) + resultat.get(1),
				chiffre.get(2) + resultat.get(2));
	}

	private static List<String> aggrandirLeToutPitiLCD(int hauteur, List<String> LCDtoutpiti) {
		String résultat[] = new String[calculerLaHauteurDuLCD(hauteur)];
		dupliquerLignes(hauteur, LCDtoutpiti, résultat);
		résultat = renseignerLes3LignesVerticales(hauteur, résultat, LCDtoutpiti);
		return List.of(résultat);
	}

	private static void dupliquerLignes(int hauteur, List<String> LCDtoutpiti, String[] résultat) {
		for (int i = 1; i <= hauteur; i++) {
			résultat[i] = LCDtoutpiti.get(1).replace("_", " ");
			résultat[i + hauteur + 1] = LCDtoutpiti.get(2).replace("_", " ");
		}
	}

	private static String[] renseignerLes3LignesVerticales(int hauteur, String[] résultat, List<String> LCDtoutpiti) {
		résultat[getIndexLigneVide(0, hauteur)] = LCDtoutpiti.get(0);
		résultat[getIndexLigneVide(1, hauteur)] = " " + LCDtoutpiti.get(1).charAt(1) + " ";
		résultat[getIndexLigneVide(2, hauteur)] = " " + LCDtoutpiti.get(2).charAt(1) + " ";
		return résultat;
	}

	private static int getIndexLigneVide(int numéroLigne, int hauteur) {
		return hauteur * numéroLigne + numéroLigne;
	}
}
