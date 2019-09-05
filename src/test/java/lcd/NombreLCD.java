package lcd;

import java.util.List;
import java.util.stream.Stream;

public enum NombreLCD {
	UN(1, List.of("   ", "  |", "  |")),
	DEUX(2, List.of(" _ ", " _|", "|_ ")),
	TROIS(3, List.of(" _ ", " _|", " _|")),
	QUATRE(4, List.of("   ", "|_|", "  |")),
	CINQ(5, List.of(" _ ", "|_ ", " _|")),
	SIX(6, List.of(" _ ", "|_ ", "|_|")),
	SEPT(7, List.of(" _ ", "  |", "  |")),
	HUIT(8, List.of(" _ ", "|_|", "|_|")),
	NEUF(9, List.of(" _ ", "|_|", " _|")),
	ZERO(0, List.of(" _ ", "| |", "|_|"));

	private int valeur;
	private List<String> representationLCD;

	private NombreLCD(int valeur, List<String> representationLCD) {
		this.valeur = valeur;
		this.representationLCD = representationLCD;
	}

	public static List<String> of(int i) {
		return Stream.of(values()).filter(nombre -> nombre.valeur == i).map(nombre -> nombre.representationLCD)
				.findAny().get();
	}

}
