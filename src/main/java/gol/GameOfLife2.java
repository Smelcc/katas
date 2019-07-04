package gol;

import java.util.ArrayList;
import java.util.List;

public class GameOfLife2 {
	Grille grille;

	public GameOfLife2(String string) {
		grille = new Grille(string);
	}

	public void iterer() {

	}

	public String getResultat() {
		Grille grilleResultat = new Grille();
		ajouterCellulesQuiNaissentAuResultat(grilleResultat);
		ajouterCellulesQuiSurviventAuResultat(grilleResultat);
		return grilleResultat.toString();
	}

	private void ajouterCellulesQuiSurviventAuResultat(Grille grilleResultat) {
		calculerGrilleSurvivants().forEach(coordonnee -> grilleResultat.ajouterCellule(coordonnee));
	}

	private void ajouterCellulesQuiNaissentAuResultat(Grille grilleResultat) {
		for (int abscisse = 0; abscisse < grille.getTailleGrille(); abscisse++) {
			for (int ordonnee = 0; ordonnee < grille.getTailleGrille(); ordonnee++) {
				ajouterAuResultatSiLaCelluleNait(grilleResultat, abscisse, ordonnee);
			}
		}
	}

	private boolean isCoordonneeVide(Cellule coordonnée) {
		return grille.getCellule(coordonnée) == null;
	}

	private void ajouterAuResultatSiLaCelluleNait(Grille grilleResultat, int abscisse, int ordonnee) {
		Cellule coordonnée = new Cellule(abscisse, ordonnee);
		if (isCoordonneeVide(coordonnée)) {
			if (déterminerSiCelluleNait(coordonnée)) {
				grilleResultat.ajouterCellule(coordonnée);
			}
		}
	}

	private boolean déterminerSiCelluleNait(Cellule coordonnée) {
		return getNombreDeVoisin(coordonnée) == 3;
	}

	private List<Cellule> calculerGrilleSurvivants() {
		List<Cellule> survivants = new ArrayList<Cellule>();
		for (Cellule coordonnée : grille.getCellules()) {
			boolean celluleSurvit = déterminerSiCelluleSurvit(coordonnée);
			if (celluleSurvit) {
				survivants.add(coordonnée);
			}
		}
		return survivants;
	}

	private boolean déterminerSiCelluleSurvit(Cellule coordonnée) {
		int nbVoisins = getNombreDeVoisin(coordonnée);
		return nbVoisins == 2 || nbVoisins == 3;
	}

	private int getNombreDeVoisin(Cellule coordonnée) {
		int nbVoisins = 0;
		for (Cellule voisinPotentiel : grille.getCellules()) {
			if (isVoisin(coordonnée, voisinPotentiel))
				++nbVoisins;
		}
		return nbVoisins;
	}

	private boolean isVoisin(Cellule coordonnée, Cellule coordonnée2) {
		if (coordonnée == coordonnée2) {
			return false;
		}
		int x = coordonnée.getX() - coordonnée2.getX();
		int y = coordonnée.getY() - coordonnée2.getY();
		return (x >= -1 && x <= 1) && (y >= -1 && y <= 1);
	}

}
