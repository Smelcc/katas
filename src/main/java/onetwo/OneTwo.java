package onetwo;

import java.util.StringJoiner;
import java.util.stream.Stream;

public class OneTwo {

	enum Conversion {
		ONE("1", "one"), TWO("2", "two"), THREE("3", "three"), FOUR("4", "four"), FIVE("5", "five"), SIX("6", "six"),
		SEVEN("7", "seven"), EIGHT("8", "eight"), NINE("9", "nine");
		private Conversion(String value, String displayValue) {
			this.value = value;
			this.displayValue = displayValue;
		}

		private String value;
		private String displayValue;

		public static String fromIntRepresentation(String input) {
			return Stream.of(values()).filter(conversion -> conversion.value.equals(input))
					.map(conversion -> conversion.displayValue).findFirst().get();
		}

		public static String fromStringRepresentation(String input) {
			return Stream.of(values()).filter(conversion -> conversion.displayValue.equals(input))
					.map(conversion -> conversion.value).findFirst().get();
		}
	}

	// Exo 1 : "1 1 3" -> "two one one three"
	public String readValue(String input) {
		StringJoiner result = new StringJoiner(" ");
		int nombreOccurences = 0;
		String chiffrePrecedent = null;
		for (String chiffre : input.split(" ")) {
			if (isSeuilAtteint(nombreOccurences) || isNouveauChiffre(chiffrePrecedent, chiffre)) {
				result.add(convertFromInt(nombreOccurences, chiffrePrecedent));
				nombreOccurences = 0;
				chiffrePrecedent = null;
			}
			chiffrePrecedent = chiffre;
			nombreOccurences++;
		}
		result.add(convertFromInt(nombreOccurences, chiffrePrecedent));
		return result.toString();
	}

	private boolean isNouveauChiffre(String chiffrePrecedent, String chiffre) {
		return chiffrePrecedent != null && !chiffre.equals(chiffrePrecedent);
	}

	private boolean isSeuilAtteint(int nombreOccurences) {
		return nombreOccurences == 9;
	}

	private String convertFromInt(int nombre, String value) {
		return Conversion.fromIntRepresentation(String.valueOf(nombre)) + " " + Conversion.fromIntRepresentation(value);
	}

	// Exo 2 : "two one one three" -> "1 1 3"
	public String writeValue(String input) {
		StringJoiner result = new StringJoiner(" ");

		String[] split = input.split(" ");
		int indexDepart = 0;
		while (split.length > indexDepart) {
			construireResultat(result, split, indexDepart);
			indexDepart += 2;
		}

		return result.toString();
	}

	private void construireResultat(StringJoiner result, String[] split, int indexDepart) {
		int nbOcurrence2 = Integer.parseInt(Conversion.fromStringRepresentation(split[indexDepart]));
		String chiffre2 = Conversion.fromStringRepresentation(split[indexDepart + 1]);
		for (int i = 0; i < nbOcurrence2; i++) {
			result.add(chiffre2);
		}
	}
}
