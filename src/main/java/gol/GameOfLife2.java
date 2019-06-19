package gol;

import java.util.StringJoiner;

public class GameOfLife2 {
	Grille grille;

	public GameOfLife2(String string) {
		grille = new Grille(string);
	}

	public void iterer() {

	}

	public String getResultat() {
		return getSurvivants();
	}

	private String getSurvivants() {
		StringJoiner survivants = new StringJoiner(";");
		for (Coordonnée coordonnée : grille.getCoordonnées()) {
			boolean celluleSurvit = déterminerSiCelluleSurvit(coordonnée);
			if (celluleSurvit) {
				survivants.add(coordonnée.toString());
			}
		}
		return survivants.length() == 0 ? "vide" : survivants.toString();
	}

	private boolean déterminerSiCelluleSurvit(Coordonnée coordonnée) {
		int nbVoisins = 0;
		for (Coordonnée voisinPotentiel : grille.getCoordonnées()) {
			if (isVoisin(coordonnée, voisinPotentiel)) {
				++nbVoisins;
			}
		}
		return nbVoisins == 2;
	}

	private boolean isVoisin(Coordonnée coordonnée, Coordonnée coordonnée2) {
		if (coordonnée == coordonnée2) {
			return false;
		}
		int x = coordonnée.getX() - coordonnée2.getX();
		int y = coordonnée.getY() - coordonnée2.getY();
		return (x >= -1 && x <= 1) && (y >= -1 && y <= 1);
	}

}
