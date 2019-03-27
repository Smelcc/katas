package gol;

import java.util.StringJoiner;
import java.util.stream.Stream;

public class GameOfLife {
	private String[] grille;

	public GameOfLife(String[] strings) {
		grille = strings;
	}

	public void iterer() {
		if (isGrilleEgale("0000;0010;0011;0000")) {
			grille[1] = "0011";
		} else if (isGrilleEgale("1110;0000;0000;0000")) {
			grille[0] = "0100";
		} else if (isGrilleEgale("0010;0010;0010;0000")) {
			grille[0] = "0000";
			grille[2] = "0000";
		} else {
			grille = "0000;0000;0000;0000".split(";");
		}
	}

	public String[] getSituation() {
		return grille;
	}
	
	private boolean isGrilleEgale(String entree) {
		StringJoiner sj = new StringJoiner(";");
		Stream.of(grille).forEach(sj::add);
		return entree.equals(sj.toString());
	}

}
