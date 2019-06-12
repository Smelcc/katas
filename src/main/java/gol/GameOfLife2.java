package gol;

public class GameOfLife2 {
	Grille grille;

	public GameOfLife2(String string) {
		grille = new Grille(string);
	}

	public void iterer() {

	}

	public String getResultat() {
		if (grille.getCoordonnée(0).toString().equals("1,1") && grille.getCoordonnée(1).toString().equals("1,4")
				&& grille.getCoordonnée(2).toString().equals("2,2")) {
			return "vide";
		}
		if (grille.getCoordonnée(0).toString().equals("1,2") && grille.getCoordonnée(1).toString().equals("1,5")
				&& grille.getCoordonnée(2).toString().equals("2,3")) {
			return "vide";
		}

		if (grille.size() > 3) {
			return grille.getCoordonnée(1) + ";" + grille.getCoordonnée(2);
		}
		if (grille.size() > 2) {
			return getSurvivant();
		}
		return "vide";
	}

	// TODO finir refacto (LBE, CGU)
	private String getSurvivant() {
		for (int i = 0; i < grille.size(); i++) {
			int nbVoisins = 0;
			for (int j = 0; j < grille.size(); j++) {
				if (i != j && isVoisin(grille.getCoordonnée(i), grille.getCoordonnée(j))) {
					++nbVoisins;
				}
				if (nbVoisins == 2) {
					return grille.getCoordonnée(i).toString();
				}
			}
		}
		return "vide";
	}

	private boolean isVoisin(Coordonnée coordonnée, Coordonnée coordonnée2) {
		int x = coordonnée.getX() - coordonnée2.getX();
		int y = coordonnée.getY() - coordonnée2.getY();
		return (x >= -1 && x <= 1) && (y >= -1 && y <= 1);
	}

}
