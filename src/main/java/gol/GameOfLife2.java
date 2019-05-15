package gol;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GameOfLife2 {
	String[] coordonnees;
	public GameOfLife2(String string) {
		coordonnees = string.split(";");
		Arrays.sort(coordonnees);
	}

	public void iterer() {

	}

	public String getResultat() {
		if (coordonnees[0]//@TODO faire classe coordonnée FDJ) {
			return "vide";
		}
		if(coordonnees.length > 3) {
			return coordonnees[1]+";"+coordonnees[2];
		}
		if(coordonnees.length > 2) {
			return coordonnees[1];
		}
		return "vide";
	}

}
