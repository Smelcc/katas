package gol;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Grille {
	List<Cellule> cellules;

	public Grille(String string) {
		cellules = new ArrayList<>();
		for (String coor : string.split(";")) {
			cellules.add(new Cellule(coor));
		}
		cellules.sort(null);
	}

	public Grille() {
		cellules = new ArrayList<>();
	}

	public List<Cellule> getCellules() {
		return cellules;
	}

	public Cellule getCellule(int i) {
		return cellules.get(i);
	}

	public int size() {
		return cellules.size();
	}

	@Override
	public String toString() {
		if (cellules.isEmpty()) {
			return "vide";
		}
		return cellules.stream().map(Cellule::toString).collect(Collectors.joining(";"));
	}

	@Override
	public boolean equals(Object obj) {
		Grille grilleComparée = new Grille((String) obj);
		return this.toString().equals(grilleComparée.toString());
	}

	public int getTailleGrille() {
		return 7;
	}

	public void ajouterCoordonnee(int abscisse, int ordonnee) {
		this.ajouterCellule(new Cellule(abscisse, ordonnee));
	}

	public Cellule getCellule(Cellule coordonnéeEntrée) {
		return cellules.stream()
				.filter(coordonnee -> coordonnéeEntrée.compareTo(coordonnee) == 0)
				.findAny()
				.orElse(null);
	}

	public void ajouterCellule(Cellule coordonnee) {
		cellules.add(coordonnee);
		cellules.sort(null);
	}

}
