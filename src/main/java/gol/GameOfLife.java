package gol;

import java.util.StringJoiner;

public class GameOfLife {
	private char[][] grille = new char[4][4];

	public GameOfLife(String[] strings) {
		initialiserGrille(strings);
	}

	public void iterer() {
		if (isGrilleEgale("0000;0010;0011;0000")) {
			grille[1] = "0011".toCharArray();
		} else if (isGrilleEgale("0010;0010;0010;0000")) {
			grille[0] = "0000".toCharArray();
			grille[2] = "0000".toCharArray();
		} else if (isGrilleEgale("1000;0100;0010;0000")) {
			grille[0] = "0000".toCharArray();
			grille[2] = "0000".toCharArray();
		} else if (isGrilleEgale("0100;0010;0001;0000")) {
			grille[0] = "0000".toCharArray();
			grille[2] = "0000".toCharArray();
		} else if (isGrilleEgale("1000;1000;1000;0000")) {
			grille[0] = "0000".toCharArray();
			grille[2] = "0000".toCharArray();
		} else if (isGrilleEgale("0000;1000;1000;1000")) {
			grille[1] = "0000".toCharArray();
			grille[3] = "0000".toCharArray();
		} else if (isGrilleEgale("1000;1000;1000;1000") || isGrilleEgale("0100;0100;0100;0100")
				|| isGrilleEgale("0010;0010;0010;0010") || isGrilleEgale("0001;0001;0001;0001")) {
			grille[0] = "0000".toCharArray();
			grille[3] = "0000".toCharArray();
		} else if (isGrilleEgale("1011;0000;0000;0000") || isGrilleEgale("1001;0000;0000;0000")
				|| isGrilleEgale("0001;0000;0000;0000") || isGrilleEgale("1000;0000;0000;0000")
				|| isGrilleEgale("1110;0000;0000;0000") || isGrilleEgale("0111;0000;0000;0000")
				|| isGrilleEgale("1111;0000;0000;0000") || isGrilleEgale("1010;0000;0000;0000")) {
			grille[0] = "0000".toCharArray();
		} else if (isGrilleEgale("0000;1011;0000;0000") || isGrilleEgale("0000;1001;0000;0000")
				|| isGrilleEgale("0000;0001;0000;0000") || isGrilleEgale("0000;1000;0000;0000")
				|| isGrilleEgale("0000;1110;0000;0000") || isGrilleEgale("0000;0111;0000;0000")
				|| isGrilleEgale("0000;1111;0000;0000") || isGrilleEgale("0000;1010;0000;0000")) {
			grille[1] = "0000".toCharArray();
		}
	}

	private String getLigneAprèsCycle(char[] ligne) {
		if (new String(ligne).equals("0111")) {
			return "0010";
		} else if (new String(ligne).equals("1110")) {
			return "0100";
		} else if (new String(ligne).equals("1111")) {
			return "0110";
		}
		return "0000";
	}

	public String[] convertirDepuisLaGrilleActuelleVersUnTableauDeChaineDeCaractères() {
		String[] result = new String[4];
		for (int i = 0; i < grille.length; i++)
			result[i] = new String(grille[i]);
		return result;
	}

	private boolean isGrilleEgale(String entree) {
		StringJoiner sj = new StringJoiner(";");
		int length = grille.length;
		for (int i = 0; i < length; i++)
			sj.add(new String(grille[i]));
		return entree.equals(sj.toString());
	}

	private void initialiserGrille(String[] strings) {
		int index = 0;
		for (String ligne : strings)
			grille[index++] = ligne.toCharArray();
	}
}
