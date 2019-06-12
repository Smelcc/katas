package gol;

import java.util.ArrayList;
import java.util.List;

public class Grille {
	List<Coordonnée> coordonnées;

	public Grille(String string) {
		coordonnées = new ArrayList<>();
		for (String coor : string.split(";")) {
			coordonnées.add(new Coordonnée(coor));
		}
		coordonnées.sort(null);
	}

	public List<Coordonnée> getCoordonnées() {
		return coordonnées;
	}

	public Coordonnée getCoordonnée(int i) {
		return coordonnées.get(i);
	}

	public int size() {
		return coordonnées.size();
	}


}
